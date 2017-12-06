package ru.stqa.training.selenium;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class TestCall {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/tools/ff52/firefox.exe"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void TestCall() {
        wd.get("https://www.freeconferencecall.com/en/us");
        wd.findElement(By.linkText("More")).click();
        wd.findElement(By.linkText("Contact Us")).click();
        wd.findElement(By.id("contact-name")).click();
        wd.findElement(By.id("contact-name")).clear();
        wd.findElement(By.id("contact-name")).sendKeys("Ivan");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("AntohaKiselev@yandex.ru");
        wd.findElement(By.id("phone")).click();
        wd.findElement(By.id("phone")).clear();
        wd.findElement(By.id("phone")).sendKeys("893284888888");
        wd.findElement(By.id("comments")).click();
        wd.findElement(By.id("comments")).clear();
        wd.findElement(By.id("comments")).sendKeys("testtest");
        wd.findElement(By.xpath("//form[@id='frmcontact']/div[5]/div")).click();


    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
