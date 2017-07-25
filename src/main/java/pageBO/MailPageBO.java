package pageBO;

import page.MailPage;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static org.testng.Assert.assertEquals;

public class MailPageBO extends PageBO {
   MailPage mailPage = new MailPage();

   public MailPageBO verifyIfRightUsersPageIsDisplayed(String usersEmail) {
      mailPage.usersAddressOnMailPage()
            .shouldHave(text(usersEmail));
      return this;
   }

   public MailPageBO verifyNumbersOfLetterOnPage(int number) {
      LOG.info("Verify if on page 25 letters are displayed");
      mailPage.getLetters()
            .shouldHaveSize(number);
      return this;
   }

   public MailPageBO checkAndDeleteLetters(List<Integer> indexes) {
      LOG.info("Check letters and delete them");
      mailPage.checkLetter(indexes)
            .deleteCheckedLetters();
      return this;
   }

   public MailPageBO verifyIfLettersAreDeleted(List<Integer> indexes) {
      LOG.info("Verify if letters can be deleted");
      int expectedInputLettersAfterDelete = mailPage.getNumbersOfAllInputLetters() - indexes.size();
      checkAndDeleteLetters(indexes);
      int numberOfInputLettersAfterDeleting = mailPage.getNumbersOfAllInputLetters();
      assertEquals(numberOfInputLettersAfterDeleting, expectedInputLettersAfterDelete);
      return this;
   }

   public MailPageBO writeDraftLetterWithTheme(String theme) {
      LOG.info("Write Draft letter");
      mailPage.startWrittingLetter()
            .writeTheme(theme)
            .selectInputLetters();
      return this;
   }

   public MailPageBO verifyIfDraftExist(int index, String theme) {
      LOG.info("Verify if draft letter was saved");
      mailPage.selectDraft()
            .getLetters()
            .get(index)
            .$("a.msglist__row_href")
            .shouldHave(text(theme));
      return this;
   }
}
