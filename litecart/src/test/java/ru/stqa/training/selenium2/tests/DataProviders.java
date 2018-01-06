package ru.stqa.training.selenium2.tests;

import org.testng.annotations.DataProvider;
import ru.stqa.training.selenium2.model.Customer;

/**
 * Created by Антон on 05.01.2018.
 */
public class DataProviders {
  @DataProvider
  public static Object[][] validCustomers() {
    return new Object[][] {
            { Customer.newEntity()
                    .withFirstname("Adam").withLastname("Smith").withPhone("+0123456789")
                    .withAddress("Hidden Place").withPostcode("12345").withCity("New City")
                    .withCountry("US").withZone("KS")
                    .withEmail("adam"+System.currentTimeMillis()+"@smith.me")
                    .withPassword("qwerty").build() },
                /* ... */
    };
  }
}
