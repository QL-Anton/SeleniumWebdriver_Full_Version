package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Антон on 10.12.2017.
 */
public class SortGeoZonesTests extends  TestBase {

  @Test
  public  void testSortOfGeoZones(){
    login();
    wd.findElements(By.id("app-")).get(5).click();

    int countriesCount = wd.findElements(By.cssSelector("#main tbody tr")).size();//считаем кол-во стран на странице с геозонами
    System.out.println("Кол-во стран с несколькими геозонами: " + countriesCount);


    for (int i = 0; i < countriesCount; i++) {

        wd.findElements(By.cssSelector("#main tbody tr")).get(i).findElement(By.cssSelector("a")).
                click();


      List<String> listOfGeoZones = new ArrayList<>(); //создаём список для зон, который будем сортировать
      List<String> unsortedListOfGeoZones = new ArrayList<>(); //такой же список зон, но его не будем сортировать
      int geoZonesCount = wd.findElements(By.cssSelector("#main tbody tr")).size(); //кол-во зон в стране
      for (int j = 0; j < geoZonesCount; j++) {
        //находим и добавляем зоны в список
        String nameZones = wd.findElements(By.cssSelector("#main tbody tr")).get(j).findElements(By.tagName("td")).get(2).
                getAttribute("innerText");

        listOfGeoZones.add(nameZones);
        unsortedListOfGeoZones.add(nameZones);

      }
      Collections.sort(listOfGeoZones);  //сортируем зоны


      System.out.println(listOfGeoZones); //выводим список зон для визуального контроля
      Assert.assertEquals(listOfGeoZones, unsortedListOfGeoZones); //проверяем, что зоны до сортировки и после совпадают, это значит, что зоны были отсортированы по алфавиту
      wd.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");


        }


  }
}
