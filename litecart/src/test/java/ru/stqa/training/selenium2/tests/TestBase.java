package ru.stqa.training.selenium2.tests;


import org.testng.annotations.BeforeTest;
import ru.stqa.training.selenium2.applicationManager.Application;

/**
 * Created by Антон on 05.01.2018.
 */
public class TestBase {

  public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
  public Application app;

  @BeforeTest
  public void start() {
    if (tlApp.get() != null) {
      app = tlApp.get();
      return;
    }

    app = new Application();
    tlApp.set(app);

    Runtime.getRuntime().addShutdownHook(
            new Thread(() -> { app.quit(); app = null; }));
  }

  public void sleep(int n){
    try {
      Thread.sleep(n);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
