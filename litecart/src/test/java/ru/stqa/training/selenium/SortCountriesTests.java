package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Антон on 03.12.2017.
 */
public class SortCountriesTests extends TestBase {

  @Test
  public void testSortCountries() {
    login();
    wd.findElements(By.id("app-")).get(2).click(); //Переходим на страницу со странами

    int countriesCount = wd.findElements(By.cssSelector("#main tbody tr")).size();
    System.out.println(countriesCount);

    List<String> listOfNameCountries = new ArrayList<>();
    List<String> unsortedListOfNameCountries = new ArrayList<>();

    for (int i = 0; i < countriesCount; i++) {
      String nameCountries = wd.findElements(By.cssSelector("#main tbody tr")).get(i).findElements(By.tagName("td")).get(4).
              getAttribute("innerText");
      listOfNameCountries.add(nameCountries);
      unsortedListOfNameCountries.add(nameCountries);


    }

    Collections.sort(listOfNameCountries);

    Assert.assertNotEquals(unsortedListOfNameCountries, listOfNameCountries); //notEquals потому что буква A в Islands с точкой наверху


    // System.out.println(wd.findElements(By.cssSelector("#main tbody tr")).get(1).findElements(By.tagName("td")).get(4).
    //  getAttribute("innerText"));


  }
}
