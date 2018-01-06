package ru.stqa.training.selenium2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Антон on 01.01.2018.
 */
public class Page {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public Page(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 30);
  }
}
