package ru.stqa.training.selenium2.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemsIntoBin extends TestBase {


  @Test
 public  void testAddItemsIntoBin(){

     app.addItemsIntoBin();
    Assert.assertEquals(app.countItemsIntoBinOnMainPahe(),3);
    app.removeItemsFromBin();

 }
}
