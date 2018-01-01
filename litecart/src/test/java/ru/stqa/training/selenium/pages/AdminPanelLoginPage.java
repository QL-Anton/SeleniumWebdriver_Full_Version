package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Антон on 01.01.2018.
 */
public class AdminPanelLoginPage extends  Page {
  public AdminPanelLoginPage(WebDriver wd) {
    super(wd);
  }

  public AdminPanelLoginPage open() {
    wd.get("http://localhost/litecart/admin");
    return this;
  }

  public boolean isOnThisPage() {
    return wd.findElements(By.id("box-login")).size() > 0;
  }


  public AdminPanelLoginPage enterUsername(String username) {
    wd.findElement(By.name("username")).sendKeys(username);
    return this;
  }

  public AdminPanelLoginPage enterPassword(String password) {
    wd.findElement(By.name("password")).sendKeys(password);
    return this;
  }


  public void submitLogin() {
    wd.findElement(By.name("login")).click();
    wait.until((WebDriver d) -> d.findElement(By.id("box-apps-menu")));
  }


}

