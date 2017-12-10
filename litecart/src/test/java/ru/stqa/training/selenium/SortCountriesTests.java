package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Антон on 03.12.2017.
 */
public class SortCountriesTests extends TestBase {

  @Test
  public void testSortCountries() throws InterruptedException {
    login();


    wd.findElements(By.id("app-")).get(2).click(); //Переходим на страницу со странами

    int countriesCount = wd.findElements(By.cssSelector("#main tbody tr")).size();
    System.out.println("Кол-во стран: " + countriesCount);

    List<String> listOfNameCountries = new ArrayList<>();
    List<String> unsortedListOfNameCountries = new ArrayList<>();
    int[] indexOfCountriesWithSomeZones = new int[countriesCount];

    for (int i = 0; i < countriesCount; i++) {

      String nameCountries = wd.findElements(By.cssSelector("#main tbody tr")).get(i).findElements(By.tagName("td")).get(4).
              getAttribute("innerText");
      String zones = wd.findElements(By.cssSelector("#main tbody tr")).get(i).findElements(By.tagName("td")).get(5).
              getAttribute("innerText");
      if ((Integer.parseInt(zones)) != 0) {
        indexOfCountriesWithSomeZones[i] = i;
      }

      listOfNameCountries.add(nameCountries);
      unsortedListOfNameCountries.add(nameCountries);


    }


    Collections.sort(listOfNameCountries);

    Assert.assertNotEquals(unsortedListOfNameCountries, listOfNameCountries); //notEquals потому что буква A в Islands с точкой наверху
    //и список получается не отсортированнымм


//Проверка сортировки зон в странах, кол-во зон в которых !=0

    for (int j = 0; j < indexOfCountriesWithSomeZones.length; j++) {
      if (indexOfCountriesWithSomeZones[j] != 0) {  //Переходим в страницу только той строны, у которой кол-во зон больше 0
        wd.findElements(By.cssSelector("#main tbody tr")).get(indexOfCountriesWithSomeZones[j]).findElement(By.cssSelector("a")).
                click();

        List<String> listOfZonesCountries = new ArrayList<>(); //создаём список для зон, который будем сортировать
        List<String> unsortedListOfZonesCountries = new ArrayList<>(); //такой же списо зон, но его не будем сортировать
        int countriesZonesCount = wd.findElements(By.cssSelector("#main tbody tr")).size(); //кол-во зон в стране
        for (int i = 0; i < countriesZonesCount; i++) {
          //находим и добавляем зоны в список
          String nameZones = wd.findElements(By.cssSelector("#main tbody tr")).get(i).findElements(By.tagName("td")).get(2).
                  findElement(By.tagName("input")).getAttribute("value");

          listOfZonesCountries.add(nameZones);
          unsortedListOfZonesCountries.add(nameZones);

        }

        Collections.sort(listOfZonesCountries);  //сортируем зоны
        //Assert.assertEquals(listOfZonesCountries,unsortedListOfNameCountries);


        System.out.println(listOfZonesCountries);
        Assert.assertEquals(listOfZonesCountries, unsortedListOfZonesCountries); //проверяем, что зоны до сортировки и после совпадают, это значит, что зон были отсортированы по алфавиту
        wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
      }
    }


  }







     /* wd.findElements(By.cssSelector("#main tbody tr")).get(i).findElements(By.tagName("td")).get(4).click();
      int countChoseCountryZones = wd.findElements(By.cssSelector("#main tbody tr")).size();

        System.out.println(wd.findElements(By.cssSelector("#main tbody tr")).get(j).findElements(By.tagName("td")).get(3).getAttribute("value"));
        wd.findElements(By.id("app-")).get(2).click();

    */

}

