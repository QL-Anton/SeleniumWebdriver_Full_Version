package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

/**
 * Created by Антон on 17.12.2017.
 */
public class WorkWithBinTests extends TestBase {


  @Test
  public void testWorkWithBin() {


    wd.get("http://localhost/litecart/en/");  //переходи на страницу магазина
    wait.until(titleContains("Online Store"));


    String countItemInBin = wd.findElement(By.id("cart")).findElement(By.cssSelector("span.quantity")).getAttribute("innerText"); //кол-во товаров в корзине


    int k = Integer.parseInt(wd.findElement(By.id("cart")).findElement(By.cssSelector("span.quantity")).getAttribute("innerText"));


    //добавляем товар в корзину до тех пор,пока кол-во товаров в корзине не будет равно трём
    while (k != 3) {
      wd.findElement(By.linkText("Popular Products")).click(); //товары добавляем из категории популярные
      wd.findElements(By.cssSelector("#popular-products a.link")).get(1).click(); //выбираем второй в списке товар
      wd.findElement(By.name("add_cart_product")).click();  //добавляем в корзину
      wait.until(ExpectedConditions.attributeContains(By.cssSelector("span.quantity"), "innerText", String.valueOf(k + 1))); //ждём пока кол-во товара в корзине не обновится
      k = k + 1; //увеличиваем кол-во товара в корзине на 1
      wd.get("http://localhost/litecart/en/");  //переходим на страницу магазина
      wait.until(titleContains("Online Store"));
    }

    //Переходим в корзину
    wd.findElement(By.cssSelector("a[href='http://localhost/litecart/en/checkout']")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-checkout-cart")));

    //удаляем товары до тех пор, пока они есть в корзине
    while( wd.findElements(By.name("remove_cart_item")).size()!=0){
      WebElement price = wd.findElements(By.cssSelector("#box-checkout-summary tr")).get(0).findElements(By.cssSelector("td")).get(1);

      wd.findElements(By.name("remove_cart_item")).get(0).click();

      //ждём пока в таблице внизу изменится цена после удаления товара из корзины
      wait.until(ExpectedConditions.stalenessOf(price));
    }



  }
}
