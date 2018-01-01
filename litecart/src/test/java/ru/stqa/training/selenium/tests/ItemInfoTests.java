package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Антон on 11.12.2017.
 */
public class ItemInfoTests extends TestBase {

  @Test
  public void testItemInfo() {

    wd.get("http://localhost/litecart/en/");
    String regularPrice = wd.findElements(By.cssSelector("#campaign-products .regular-price")).get(0).getAttribute("innerText");
    String campaignPrice = wd.findElements(By.cssSelector("#campaign-products .campaign-price")).get(0).getAttribute("innerText");
    String nameItem = wd.findElements(By.cssSelector("#campaign-products  .name")).get(0).getAttribute("innerText");
    System.out.println("Цена до скидки " + regularPrice);
    System.out.println("Цена после скидки " + campaignPrice);
    System.out.println("Наименование товара " + nameItem);

    String color = wd.findElement(By.cssSelector("#campaign-products s.regular-price")).getCssValue("color");
    String fontSize = wd.findElement(By.cssSelector("#campaign-products s.regular-price")).getCssValue("font-size");
    String textDecoration = wd.findElement(By.cssSelector("#campaign-products s.regular-price")).getCssValue("text-decoration");
    System.out.println(color);
    System.out.println(fontSize);
    System.out.println(textDecoration);


    wd.findElements(By.cssSelector("#campaign-products  a")).get(0).click(); //кликаем по первому товару, для перехода к странице с информацией о  товаре
    wd.findElement(By.cssSelector("#view-full-page")).click(); //переходим к полной странице
    String nameItemOnPage = wd.findElement(By.cssSelector("#content .title")).getAttribute("innerText"); //наименование товара на странице товара
    System.out.println("Наименование товара на странице с товаром " + nameItemOnPage);
    String regularPriceOnPageItem = wd.findElement(By.cssSelector("#content .regular-price")).getAttribute("innerText");
    String campaignPriceOnPageItem = wd.findElement(By.cssSelector("#content .campaign-price")).getAttribute("innerText");
    System.out.println("Цена до скидки на странице товара " + regularPriceOnPageItem);
    System.out.println("Цена после скидки на странице товара " + campaignPriceOnPageItem);


    String colorOnPage = wd.findElement(By.cssSelector("#box-product div.price-wrapper del.regular-price")).getCssValue("color");
    String fontSizeOnPage = wd.findElement(By.cssSelector("#box-product div.price-wrapper del.regular-price")).getCssValue("font-size");
    String textDecorationOnPage = wd.findElement(By.cssSelector("#box-product div.price-wrapper del.regular-price")).getCssValue("text-decoration");
    System.out.println(colorOnPage);
    System.out.println(fontSizeOnPage);
    System.out.println(textDecorationOnPage);

    //Проверка наименования и цены
    Assert.assertEquals(regularPrice, regularPriceOnPageItem);
    Assert.assertEquals(campaignPrice, campaignPriceOnPageItem);
    Assert.assertEquals(nameItem, nameItemOnPage);

    //Проверка цвета и размера шрифтов
    Assert.assertEquals(color, colorOnPage);
    Assert.assertEquals(textDecoration, textDecorationOnPage);


  }
}
