package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 01.12.2017.
 */
public class TestBase {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/tools/ff52/firefox.exe"));
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }


  public  void login(){
    wd.get("http://localhost/litecart/admin/");
    wd.findElement(By.name("username")).click();                                         //Авторизация
    wd.findElement(By.name("username")).clear();
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.xpath("//div[@class='footer']//button[.='Login']")).click();
  }


  protected   boolean isElementPresent(By locator) {
            try {
                  wd.findElement(locator);
                 return true;
              } catch (NoSuchElementException e) {
                 return false;
              }
       }





  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
