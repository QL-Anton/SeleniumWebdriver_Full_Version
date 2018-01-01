package ru.stqa.training.selenium.applicationManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.training.selenium.pages.AdminPanelLoginPage;
import ru.stqa.training.selenium.pages.WorkWithBinPage;
import ru.stqa.training.selenium.pages.WorkWithMainPage;

/**
 * Created by Антон on 01.01.2018.
 */
public class Application {

  private WebDriver wd;

  private WorkWithBinPage workWithBinPage;
  private WorkWithMainPage workWithMainPage;
  private AdminPanelLoginPage adminPanelLoginPage;



  public  Application(){
    wd=new ChromeDriver();
    workWithBinPage=new WorkWithBinPage(wd);
    workWithMainPage=new WorkWithMainPage(wd);
    adminPanelLoginPage=new AdminPanelLoginPage(wd);

  }

  public void quit() {
    wd.quit();
  }
  public  void addItemIntoBin(){
    workWithMainPage.open();

  }

}

