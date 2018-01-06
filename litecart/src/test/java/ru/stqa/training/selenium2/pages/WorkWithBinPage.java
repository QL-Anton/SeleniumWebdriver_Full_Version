package ru.stqa.training.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Антон on 06.01.2018.
 */
public class WorkWithBinPage extends Page {


  public WorkWithBinPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }


  @FindBy(css = "a[href='http://localhost/litecart/en/checkout']")
  public WebElement referToBin;


  @FindBy(name = "remove_cart_item")
  public List<WebElement> countItemsIntoBin;


  public int countItemsIntoBin() {


    return  driver.findElements(By.name("remove_cart_item")).size();

  }



  public void checkWhenAllItemsRemove() {
    WebElement price = driver.findElements(By.cssSelector("#box-checkout-summary tr")).get(0).findElements(By.cssSelector("td")).get(1);
    driver.findElements(By.name("remove_cart_item")).get(0).click();
    //ждём пока в таблице внизу изменится цена после удаления товара из корзины
    wait.until(ExpectedConditions.stalenessOf(price));

  }

  public void goToBin() {
    driver.findElement(By.cssSelector("a[href='http://localhost/litecart/en/checkout']")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#box-checkout-cart")));
  }
}