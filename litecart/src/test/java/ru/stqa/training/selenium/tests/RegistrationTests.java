package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Антон on 14.12.2017.
 */
public class RegistrationTests extends TestBase {

  @Test
  public void testRegistration() {

    wd.get("http://localhost/litecart/en/");
    wd.findElement(By.cssSelector("#box-account-login a")).click(); //инициируем регистрацию нового пользователя
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).sendKeys("Test_First_Name");
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).sendKeys("Test_Last_Name");

    //Генерируем уникальный e-mail
    long current_time = System.currentTimeMillis();
    String email = String.format("user%s@testmail.com", current_time);
    System.out.println(email);
    //Заполняем обязательные для регистрации поля
    wd.findElement(By.cssSelector("#box-create-account")).findElement(By.name("email")).click();
    wd.findElement(By.cssSelector("#box-create-account")).findElement(By.name("email")).sendKeys(email);

    wd.findElement(By.cssSelector("#box-create-account")).findElement(By.name("password")).click();
    wd.findElement(By.cssSelector("#box-create-account")).findElement(By.name("password")).sendKeys("application");

    wd.findElement(By.name("confirmed_password")).click();
    wd.findElement(By.name("confirmed_password")).sendKeys("application");
    //Подтверждаем создание аккаунта
    wd.findElement(By.name("create_account")).click();

    //Разлогиниваемся
    wd.findElement(By.cssSelector("[href*=logout]")).click();

    //Залогиниваемся  вновь созданным аккаунтом
    wd.findElement(By.name("email")).sendKeys(email);
    wd.findElement(By.name("password")).sendKeys("application");
    wd.findElement(By.name("login")).click();

    //разлогиниваемся
    wd.findElement(By.cssSelector("[href*=logout]")).click();

  }
}
