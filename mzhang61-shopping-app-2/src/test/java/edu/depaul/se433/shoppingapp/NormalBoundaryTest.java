package edu.depaul.se433.shoppingapp;


import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.depaul.se433.shoppingapp.Bill;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NormalBoundaryTest {

  private TotalCostCalculator cal;

  @BeforeEach
  void setup() {
    cal = new TotalCostCalculator();
  }

  @Test
  @DisplayName("Normal boundary test")
  void testTotalCostCalculatorMin() {
    double min = cal.calculate(1, "IL", ShippingType.STANDARD);
    double expected = 11.06;
    assertEquals(expected, min);
  }

  @Test
  @DisplayName("Normal boundary test")
  void testTotalCostCalculatorMinPlusOne() {
    double minPlusOne = cal.calculate(2, "CA", ShippingType.NEXT_DAY);
    double expected1 = 27.12;
    assertEquals(expected1, minPlusOne);
  }

  @Test
  @DisplayName("Normal boundary test nomial value")
  void testTotalCostCalculatorNominal() {
    double nominal = cal.calculate(50000, "CA", ShippingType.NEXT_DAY);
    double expected2 = 53025;
    assertEquals(expected2, nominal);

  }

  @Test
  @DisplayName("Normal boundary test1")
  void testTotalCostCalculator1() {
    double normal = cal.calculate(50000, "CA", ShippingType.STANDARD);
    double expected2 = 53000;
    assertEquals(expected2, normal);

    double max = cal.calculate(99999.99, "AL", ShippingType.STANDARD);
    double expected3 = 99999.99;
    assertEquals(expected3, max, 0.1);

    double maxMinusOne = cal.calculate(99998.99, "NY", ShippingType.NEXT_DAY);
    double expected4 = 106023.92;
    assertEquals(expected3, max);
  }

  @Test
  @DisplayName("extraTest")
  void extraTest() {
    PurchaseItem test = new PurchaseItem("cookie", 5, 1);
    ShoppingCart items1 = new ShoppingCart();
    items1.addItem(test);

    Bill test1 = cal.calculate(items1, "WOW", ShippingType.STANDARD);

    double initialCost = items1.cost();
    assertEquals(5, initialCost);

    double tax = TaxCalculator.calculate(10, "WO");
    assertEquals(0, tax);

  }


}
