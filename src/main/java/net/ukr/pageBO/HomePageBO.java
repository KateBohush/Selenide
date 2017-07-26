package net.ukr.pageBO;

import net.ukr.page.HomePage;

public class HomePageBO extends PageBO {

   public MailPageBO login(String login, String password) {
      LOG.info("Login in with user`s credentials");
      new HomePage()
            .setLogin(login)
            .setPassword(password)
            .submit();
      return new MailPageBO();
   }
}
