package page;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.Utills;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MailPage {

   public SelenideElement usersAddressOnMailPage() {
      return $("p.login-button__user");
   }

   public ElementsCollection getLetters() {
      return $$(By.xpath("//tr[@id]"));
   }

   public MailPage checkLetter(List<Integer> indexes) {
      indexes.forEach(index -> getLetters().get(index).scrollTo().$("td.msglist__row-check").click());
      return this;
   }

   public int getNumbersOfAllInputLetters() {
      Utills.waitForRefresh(3);
      return Integer.parseInt($(By.xpath("//a[@id=\"0\"]//span[@class=\"sidebar__list-link-count\"]")).getText());
   }

   public MailPage deleteCheckedLetters() {
      $(By.xpath("//a[@class=\"controls-link remove\"]")).click();
      return this;
   }

   public MailPage startWrittingLetter() {
      $(By.xpath("//button[@class=\"default compose\"]")).click();
      return this;
   }

   public MailPage writeTheme(String theme) {
      $(By.name("subject")).setValue(theme);
      return this;
   }

   public MailPage selectInputLetters() {
      $(By.xpath("//a[@id=\"0\"]//span[@class=\"sidebar__list-link-name\"]")).click();
      return this;
   }

   public MailPage selectDraft() {
      $(By.xpath("//a[@id=\"10002\"]//span[@class=\"sidebar__list-link-name\"]")).click();
      return this;
   }

}

