package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Антон on 24.12.2017.
 */
public class OpenInNewWindowTests extends TestBase {


  @Test
  public void testOpenInNewWindow(){

    login();
    wd.findElements(By.id("app-")).get(2).click(); //Переходим на страницу со странами
    wd.findElement(By.cssSelector(String.format("a[href='http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=AR']"))).click();
    int countReferToNewWindow=wd.findElements(By.cssSelector("i.fa.fa-external-link")).size();

    for(int i=0;i<countReferToNewWindow;i++){
      String originalWindow=wd.getWindowHandle();
      Set<String> existingWindow=wd.getWindowHandles();
      wd.findElements(By.cssSelector("i.fa.fa-external-link")).get(i).click();
      String newWindow=wait.until(anyWindowOtherThan(existingWindow));
      wd.switchTo().window(newWindow);
      wd.close();
      wd.switchTo().window(originalWindow);




    }



    }




  }

