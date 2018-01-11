package ru.stqa.training.selenium2.applicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.training.selenium2.model.Customer;
import ru.stqa.training.selenium2.pages.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Антон on 01.01.2018.
 */
public class Application {

  private WebDriver driver;
  public WebDriverWait wait;
  private RegistrationPage registrationPage;
  private AdminPanelLoginPage adminPanelLoginPage;
  private CustomerListPage customerListPage;
  private WorkWithMainPage workWithMainPage;
  private WorkWithBinPage workWithBinPage;

  public Application() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 30);

    registrationPage = new RegistrationPage(driver);
    adminPanelLoginPage = new AdminPanelLoginPage(driver);
    customerListPage = new CustomerListPage(driver);
    workWithMainPage = new WorkWithMainPage(driver);
    workWithBinPage = new WorkWithBinPage(driver);
  }

  public void quit() {
    driver.quit();
  }

  public void registerNewCustomer(Customer customer) {
    registrationPage.open();
    registrationPage.firstnameInput.sendKeys(customer.getFirstname());
    registrationPage.lastnameInput.sendKeys(customer.getLastname());
    registrationPage.address1Input.sendKeys(customer.getAddress());
    registrationPage.postcodeInput.sendKeys(customer.getPostcode());
    registrationPage.cityInput.sendKeys(customer.getCity());
    registrationPage.selectCountry(customer.getCountry());
    registrationPage.selectZone(customer.getZone());
    registrationPage.emailInput.sendKeys(customer.getEmail());
    registrationPage.phoneInput.sendKeys(customer.getPhone());
    registrationPage.passwordInput.sendKeys(customer.getPassword());
    registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());
    registrationPage.createAccountButton.click();
  }

  public Set<String> getCustomerIds() {
    if (adminPanelLoginPage.open().isOnThisPage()) {
      adminPanelLoginPage.enterUsername("admin").enterPassword("admin").submitLogin();
    }

    return customerListPage.open().getCustomerIds();
  }

  public  int countItemsIntoBinOnMainPahe(){
    return  Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getAttribute("innerText"));
  }


  public WorkWithMainPage workWithMainPage() {
    return workWithMainPage;
  }

  public WorkWithBinPage workWithBinPage() {
    return workWithBinPage;
  }

  public void sleep(int n) {
    try {
      Thread.sleep(n);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void addItemsIntoBin() {
    workWithMainPage.open();

    int k = workWithMainPage.returnCurrentCountItemsInBin();
    while (k != 3) {
      workWithMainPage.popularProducts.click();
      sleep(500);
      workWithMainPage.chooseItem();
      workWithMainPage.addCartProduct.click();
      wait.until(ExpectedConditions.attributeContains(By.cssSelector("span.quantity"), "innerText", String.valueOf(k + 1)));
      k = k + 1;
            workWithMainPage.open();


    }

   // removeItemsFromBin();
  }


  public void removeItemsFromBin() {


    workWithBinPage.goToBin();

    while (workWithBinPage.countItemsIntoBin() != 0) {

      workWithBinPage.checkWhenAllItemsRemove();

    }

  }

}


