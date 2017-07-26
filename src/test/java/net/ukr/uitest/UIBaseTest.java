package net.ukr.uitest;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import net.ukr.utill.PropertyLoader;


import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static net.ukr.utill.Constants.CHROME_DRIVER;
import static net.ukr.utill.Constants.SELENID_BROWSER;

public abstract class UIBaseTest {

   @Rule
   public ScreenShooter screenShooter = ScreenShooter.failedTests();
   protected static final Logger LOG = Logger.getLogger(UIBaseTest.class);

   @BeforeClass
   public void setBrowser() {
      System.setProperty(CHROME_DRIVER, PropertyLoader.getProperty(CHROME_DRIVER));
      System.setProperty(SELENID_BROWSER, PropertyLoader.getProperty(SELENID_BROWSER));
   }

   @BeforeMethod
   public void startTest() {
      LOG.info("\nStart Test");
   }

   @AfterMethod(alwaysRun = true)
   public void close(ITestResult result) {
      if (!result.isSuccess())
         LOG.error("The Test Failed!");
      LOG.info("The Test is ended.\nClose driver");
      closeWebDriver();
   }
}
