package core;


import com.codeborne.selenide.Selenide;

public class Utills {

   public static void waitForRefresh(int sec){
      Selenide.sleep(sec);
   }
}
