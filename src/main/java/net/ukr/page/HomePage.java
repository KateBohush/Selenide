package net.ukr.page;

import com.codeborne.selenide.Selenide;
import net.ukr.core.CustomException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class HomePage {
   private final String URL = "https://mail.ukr.net";

   public HomePage() {
      open(URL);
   }

   public HomePage setLogin(String login) {
      $("#id-1").setValue(login);
      return this;
   }

   public HomePage setPassword(String password) {
      $("#id-2").setValue(password).pressEnter();
      return this;
   }

   public MailPage submit() {
      checkForErrorLogin();
      return Selenide.page(MailPage.class);
   }

   private void checkForErrorLogin() throws CustomException {
      if ($("p.form__error").isDisplayed())
         throw new CustomException("Login or Password are not correct!");
   }
}
