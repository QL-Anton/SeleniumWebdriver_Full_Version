package ru.stqa.training.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Антон on 01.01.2018.
 */
public class Page {
  protected WebDriver wd;
  protected WebDriverWait wait;

  public Page(WebDriver wd) {
    this.wd = wd;
    wait = new WebDriverWait(wd, 10);
  }
}
