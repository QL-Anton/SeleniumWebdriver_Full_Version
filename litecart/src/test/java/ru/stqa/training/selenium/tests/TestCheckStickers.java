package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Антон on 02.12.2017.
 */
public class TestCheckStickers extends  TestBase {


  @Test
  public void testCheckStickers() {

    wd.get("http://localhost/litecart/en/");

    wd.findElement(By.cssSelector("a[href='#campaign-products']")).click();
    int countCampaign = wd.findElements(By.cssSelector("#campaign-products a.link")).size();
    for (int i = 0; i < countCampaign; i++) {
      List<WebElement> itemsCamapign = wd.findElements(By.cssSelector("#campaign-products a.link"));
      int countStickers = itemsCamapign.get(i).findElements(By.cssSelector("div.sticker")).size();
      Assert.assertEquals(itemsCamapign.size(), countStickers);

    }
    System.out.println(countCampaign);

    wd.findElement(By.cssSelector("a[href='#popular-products']")).click();
    int countPopular = wd.findElements(By.cssSelector("#popular-products a.link")).size();
    for (int i = 0; i < countPopular; i++) {
      List<WebElement> itemsPopular = wd.findElements(By.cssSelector("#popular-products a.link"));
      int countStickers = itemsPopular.get(i).findElements(By.cssSelector("div.sticker")).size();
      Assert.assertEquals(1, countStickers);

    }
    System.out.println(countPopular);


    wd.findElement(By.cssSelector("a[href='#latest-products']")).click();
    int countLatest = wd.findElements(By.cssSelector("#latest-products a.link")).size();
    for (int i = 0; i < countLatest; i++) {
      List<WebElement> itemsLatest = wd.findElements(By.cssSelector("#latest-products a.link"));
      int countStickers = itemsLatest.get(i).findElements(By.cssSelector("div.sticker")).size();
      Assert.assertEquals(1, countStickers);

    }
    System.out.println(countLatest);
  }
}
