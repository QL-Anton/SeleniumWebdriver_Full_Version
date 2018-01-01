package ru.stqa.training.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Антон on 01.01.2018.
 */
public class WorkWithBinPage extends  Page {

  public WorkWithBinPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

}
