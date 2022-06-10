package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EquivalencePartitioning {

  private TotalCostCalculator cal;

  @BeforeEach
  void setup() {
    cal = new TotalCostCalculator();
  }

  @Test
  @DisplayName("weakNormal")
  void weakNormalTest() {
    double first = cal.calculate(1, "IL", ShippingType.NEXT_DAY);
    double expected = 26.06;
    assertEquals(expected, first);
  }


  @Test
  @DisplayName("weakNormal")
  void weakNormalTest1() {
    double first = cal.calculate(49, "NY", ShippingType.STANDARD);
    double expected = 61.94;
    assertEquals(expected, first);
  }

  @Test
  @DisplayName("weakNormal")
  void weakNormalTest2() {
    double first = cal.calculate(50.01, "CA", ShippingType.STANDARD);
    double expected = 53.01;
    assertEquals(expected, first, 0.0099);

    double first1 = cal.calculate(5000.3, "IL", ShippingType.NEXT_DAY);
    double expected1 = 5325.31;
    assertEquals(expected1, first1, 0.0099);
  }

  @Test
  @DisplayName("weakNormal")
  void weakNormalTest3() {
    double first = cal.calculate(500.55, "NY", ShippingType.STANDARD);
    double expected = 530.58;
    assertEquals(expected, first, 0.0099);

    double first1 = cal.calculate(99999.99, "CA", ShippingType.NEXT_DAY);
    double expected1 = 106024.98;
    assertEquals(expected, first, 0.0099);
  }

  @Test
  @DisplayName("weakNormal robust")
  void weakNormalRobustTest4() {

    assertThrows(IllegalArgumentException.class,
        () -> cal.calculate(0, "CA", ShippingType.NEXT_DAY));


  }

  @Test
  @DisplayName("weakNormal robust")
  void weakNormalRobustTest5() {
    assertThrows(IllegalArgumentException.class,
        () -> cal.calculate(5, "CHA", ShippingType.NEXT_DAY));

  }

  @Test
  @DisplayName("weakNormal robust")
  void weakNormalRobustTest6() {
    assertThrows(NullPointerException.class, () -> cal.calculate(5, "CA", null));

  }

  @Test
  @DisplayName("strongNormal")
  void strongNormalTest1() {
    double first = cal.calculate(1, "CA", ShippingType.NEXT_DAY);
    double expected = 26.06;
    assertEquals(expected, first, 0.0099);
  }

  @Test
  @DisplayName("strongNormal")
  void strongNormalTest2() {
    double first = cal.calculate(1, "NY", ShippingType.STANDARD);
    double expected = 11.06;
    assertEquals(expected, first, 0.0099);
  }

  @Test
  @DisplayName("strongNormal")
  void strongNormalTest3() {
    double first = cal.calculate(50, "NY", ShippingType.STANDARD);
    double expected = 63;
    assertEquals(expected, first, 0.0099);
  }

  @Test
  @DisplayName("strongNormal")
  void strongNormalTest4() {
    double first = cal.calculate(100, "IL", ShippingType.NEXT_DAY);
    double expected = 131;
    assertEquals(expected, first, 0.0099);
  }

  @Test
  @DisplayName("strongNormal")
  void strongNormalTest5() {
    double first = cal.calculate(1000.59, "IL", ShippingType.STANDARD);
    double expected = 1060.62;
    assertEquals(expected, first, 0.0099);

    double first2 = cal.calculate(15000.25, "NY", ShippingType.STANDARD);
    double expected2 = 15900.26;
    assertEquals(expected2, first2, 0.0099);

    double first3 = cal.calculate(50000.97, "CA", ShippingType.NEXT_DAY);
    double expected3 = 53026.02;
    assertEquals(expected3, first3, 0.0099);

    double first1 = cal.calculate(5000.59, "CA", ShippingType.NEXT_DAY);
    double expected1 = 5325.62;
    assertEquals(expected1, first1, 0.0099);


  }

  @Test
  @DisplayName("strongNormal")
  void strongNormalTest6() {
    double first = cal.calculate(59999.3, "IL", ShippingType.NEXT_DAY);
    double expected = 63624.25;
    assertEquals(expected, first, 0.0099);
  }

  @Test
  @DisplayName("strongNormal")
  void strongNormalTest7() {
    double first = cal.calculate(89999.99, "NY", ShippingType.STANDARD);
    double expected = 95399.98;
    assertEquals(expected, first, 0.0099);

    double first1 = cal.calculate(99950.99, "IL", ShippingType.NEXT_DAY);
    double expected1 = 105973.04;
    assertEquals(expected1, first1, 0.0099);
  }

  @Test
  @DisplayName("strongRobust")
  void strongRobust() {
    assertThrows(NullPointerException.class, () -> cal.calculate(-1, "NY", ShippingType.STANDARD));

  }

  @Test
  @DisplayName("strongRobust")
  void strongRobust1() {
    assertThrows(NullPointerException.class, () -> cal.calculate(0, "NA", null));

  }

  @Test
  @DisplayName("strongRobust")
  void strongRobust2() {
    assertThrows(NullPointerException.class, () -> cal.calculate(0, "NA", ShippingType.STANDARD));

  }

  @Test
  @DisplayName("strongRobust")
  void strongRobust3() {
    double first = cal.calculate(100000, "NY", ShippingType.STANDARD);
    double expected = 160000;
    assertEquals(expected, first, 0.0099);

  }
}