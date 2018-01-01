package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by Антон on 30.11.2017.
 */
public class TestClickAllElements extends TestBase {


  @Test
  public void testClickAll() {
 login();

 //Прокликиваем все элементы меню, если у меню есть подменю, то кликаем по нему и проверяем наличие заголовка
    int count = wd.findElements(By.id("app-")).size();
    for (int i = 0; i < count; i++) {


      assertTrue(isElementPresent(By.tagName("h1")));

      System.out.println("Menu " + wd.findElement(By.tagName("h1")).getText().toString());

      if (wd.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li")).size() != 0) {
        int countSubMenu = wd.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li")).size();
        for (int j = 0; j < countSubMenu; j++) {
          List<WebElement> elementsSubMenu = wd.findElements(By.cssSelector("ul#box-apps-menu li.selected ul li"));
          elementsSubMenu.get(j).click();
          isElementPresent(By.tagName("h1"));

          System.out.println("SubMenu " + wd.findElement(By.tagName("h1")).getText().toString());

        }
      }


    }


  }


}
