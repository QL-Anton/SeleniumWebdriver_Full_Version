package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Created by Антон on 15.12.2017.
 */
public class AddNewProductTests extends TestBase {

  @Test
  public void testAddNewProduct() {
    login();
    wd.findElement(By.linkText("Catalog")).click(); //Переходим в меню каталог
    wd.findElement(By.linkText("Add New Product")).click();
    //Заполняем поля нового продукта
    long current_time = System.currentTimeMillis();
    String newProduct = String.format("product%s", current_time);
    wd.findElement(By.cssSelector("input[name='name[en]']")).sendKeys(newProduct); //заполняем имя продукта
    wd.findElement(By.name("code")).sendKeys("12345"); // заполняем код продукта
    wd.findElement(By.name("quantity")).clear();
    wd.findElement(By.name("quantity")).sendKeys("10"); //кол-во товара

    wd.findElement(By.xpath("(//input[@name='product_groups[]'])[2]")).click(); //выбираем Male

    wd.findElement(By.xpath("(//input[@name='categories[]'])[2]")).click(); //Выбираем категорию игрушки Rubber Ducks

    wd.findElements(By.cssSelector("label.btn.btn-default")).get(0).click(); //устанавливаем Enable для товара


    wd.findElement(By.linkText("Information")).click();
    new Select(wd.findElement(By.name("manufacturer_id"))).selectByVisibleText("ACME Corp."); //Выбираем корпорацию

    wd.findElement(By.name("keywords")).sendKeys("test");

    wd.findElement(By.name("short_description[en]")).sendKeys("Good item!");

    wd.findElement(By.cssSelector("div.trumbowyg-editor")).sendKeys("Very good item, buy!");


    wd.findElement(By.linkText("Prices")).click();

    // задаем цену
      new Select(wd.findElement(By.name("purchase_price_currency_code"))).selectByVisibleText("US Dollars");

    wd.findElement(By.name("prices[USD]")).sendKeys("1000");

    wd.findElement(By.name("save")).click();

   wd.findElement(By.linkText(newProduct));
  }
}
