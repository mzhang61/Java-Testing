package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MockTest {

  @Test
  @DisplayName("mock part a")
  public void very_mock_test() {

    LocalDate date = LocalDate.now();

    Purchase n1 = Purchase.make("Nick", date, 500, "IL", "STANDARD");
    Purchase n2 = Purchase.make("Nick", date, 100, "IL", "STANDARD");

    List<Purchase> files = Arrays.asList(n1, n2);
    //Arrays.asList("apple","juice","smoothie");

    PurchaseDBO purDBO = mock(PurchaseDBO.class);
    when(purDBO.getPurchases(anyString())).thenReturn(files);

    PurchaseAgent m = new PurchaseAgent(purDBO);
    double test1 = m.averagePurchase("Nick");
    double expected = (n1.getCost() + n2.getCost()) / 2;
    assertEquals(expected, test1);
  }


  //evaluate whether PurchaseAgent makes the correct call to PurchaseDBO in the
  //save() function. Again do not interact with the actual database
  @Test
  @DisplayName("mock part b")
  public void very_mock_savefunction() {
    LocalDate date = LocalDate.now();

    PurchaseDBO purDBO = mock(PurchaseDBO.class);

    Purchase n1 = Purchase.make("Nick", date, 500, "IL", "STANDARD");

    List<Purchase> files = Arrays.asList(n1);
    //Arrays.asList("apple","juice","smoothie");

    PurchaseAgent m = new PurchaseAgent(purDBO);
    m.save(n1);
    verify(purDBO).savePurchase(n1);
  }

}
