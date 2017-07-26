import core.CustomException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageBO.HomePageBO;
import utill.PropertyLoader;

import java.util.Arrays;

import static utill.Constants.*;

public class UkrNetTest extends UIBaseTest {


   @DataProvider(name = "fakeData", parallel = true)
   public Object[][] notExistUser() {
      return new Object[][]{
            {FAKE_LOGIN, FAKE_PASSWORD},
            {EMPTY_STRING, EMPTY_STRING},
      };
   }

   @DataProvider(name = "data", parallel = true)
   public Object[][] dataForRealUser() {
      return new Object[][]{
            {PropertyLoader.getProperty(LOGIN), PropertyLoader.getProperty(PASSWORD)}
      };
   }

   @Test(dataProvider = "fakeData", expectedExceptions = CustomException.class)
   public void failedLogin(String login, String password) {
      new HomePageBO().login(login, password);
   }


   @Test(dataProvider = "data")
   public void loginSuccessAndRightPageIsDisplayed(String login, String password) {
      new HomePageBO().login(login, password)
            .verifyIfRightUsersPageIsDisplayed(PropertyLoader.getProperty(USER_EMAIL))
            .verifyNumbersOfLetterOnPage(25)
            .verifyIfLettersAreDeleted(Arrays.asList(1, 4, 6, 10, 16, 18))
            .writeDraftLetterWithTheme(THEME)
            .verifyIfDraftExist(0, THEME);
   }

}
