package ru.stqa.training.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

/**
 * Created by Антон on 01.01.2018.
 */
public class WorkWithMainPage extends Page {


  public WorkWithMainPage(WebDriver wd) {
    super(wd);
    PageFactory.initElements(wd, this);
  }

  public void open() {
    wd.get("http://localhost/litecart/en/");  //переходи на страницу магазина
    wait.until(titleContains("Online Store"));
  }

  @FindBy(css = "#cart span.quantity")
  public WebElement currentCountItems;


}
