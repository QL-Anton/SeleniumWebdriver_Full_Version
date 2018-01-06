package ru.stqa.training.selenium2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ru.stqa.training.selenium2.tests.TestBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

/**
 * Created by Антон on 05.01.2018.
 */
public class WorkWithMainPage extends Page {

  public WorkWithMainPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void open() {
    driver.get("http://localhost/litecart/en/");  //переходи на страницу магазина
    wait.until(titleContains("Online Store"));
  }

  @FindBy(css = "#cart span.quantity")
  public WebElement currentCountItems;


  @FindBy(css = "#popular-products a.link")
  public List<WebElement> items;

  @FindBy(linkText = "Popular Products")
  public WebElement popularProducts;

  @FindBy(name = "add_cart_product")
  public  WebElement addCartProduct;

  public void chooseCategory(){
    popularProducts.click();
  }

  public void  chooseItem(){
    items.get(1).click();
  }



  public int returnCurrentCountItemsInBin(){
    int k=Integer.parseInt(currentCountItems.getAttribute("innerText"));
    return  k;
  }
}
