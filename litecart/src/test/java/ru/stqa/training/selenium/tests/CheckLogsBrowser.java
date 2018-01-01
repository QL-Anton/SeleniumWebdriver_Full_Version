package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Антон on 30.12.2017.
 */
public class CheckLogsBrowser extends TestBase {


  @Test
  public void testCheckLogs() {
    login();
    wd.findElement(By.cssSelector("a[href*='?app=catalog&doc=catalog']")).click();
    wd.findElement(By.cssSelector("a[href*='?app=catalog&doc=catalog&category_id=1']")).click();

    int countItems = wd.findElements(By.cssSelector("tr img")).size();


    for (int i = 0; i < countItems; i++) {
      wd.findElements(By.cssSelector("#main tbody tr")).get(i + 3).findElement(By.tagName("a")).click();
      for (LogEntry logEntry : wd.manage().logs().get("browser").getAll()) {
        Assert.assertEquals(logEntry.getMessage(), "");
      }
      wd.navigate().back();
    }

  }
}

