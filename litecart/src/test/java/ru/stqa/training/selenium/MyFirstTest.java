package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by Антон on 25.11.2017.
 */
public class MyFirstTest {

  private WebDriver driver;
  private WebDriverWait wait;


  @BeforeMethod
  public void start() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void myFirstTest() {
    driver.get("http://www.yandex.by/");
    driver.findElement(By.id("text")).sendKeys("Test");
    driver.findElement(By.xpath("//div[@class='search2__button']//button[.='Найти']")).click();



  }


  @AfterMethod
  public void stop() {
    driver.quit();
    driver = null;

  }
}
