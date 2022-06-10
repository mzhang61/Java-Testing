
package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ParameterizedTest1 {

  @ParameterizedTest
  @MethodSource("provideQuickTest")
  @DisplayName("moreArgument")
  public void provideQuickTest(double expected, double initialCost, String state,
      ShippingType type) {
    TotalCostCalculator cal = new TotalCostCalculator();
    assertEquals(expected, cal.calculate(initialCost, state, type), 0.099);
  }

  private static Stream<Arguments> provideQuickTest() {
    return Stream.of(
        Arguments.of(26.06, 1, "IL", ShippingType.NEXT_DAY),
        Arguments.of(11.06, 1, "IL", ShippingType.STANDARD),
        Arguments.of(61.94, 49, "NY", ShippingType.STANDARD),
        Arguments.of(53.01, 50.01, "CA", ShippingType.STANDARD),
        Arguments.of(5325.31, 5000.3, "IL", ShippingType.NEXT_DAY),
        Arguments.of(530.58, 500.55, "NY", ShippingType.STANDARD),
        Arguments.of(106024.98, 99999.99, "CA", ShippingType.NEXT_DAY),
        Arguments.of(26.06, 1, "CA", ShippingType.NEXT_DAY),
        Arguments.of(11.06, 1, "NY", ShippingType.STANDARD),
        Arguments.of(63, 50, "NY", ShippingType.NEXT_DAY),
        Arguments.of(131, 100, "IL", ShippingType.NEXT_DAY),
        Arguments.of(1060.62, 1000.59, "IL", ShippingType.STANDARD),
        Arguments.of(5000.59, 5325.62, "CA", ShippingType.NEXT_DAY),
        Arguments.of(15900.26, 15000.25, "NY", ShippingType.STANDARD),
        Arguments.of(52026.02, 50000.97, "CA", ShippingType.NEXT_DAY),
        Arguments.of(63624.25, 59999.30, "IL", ShippingType.NEXT_DAY),
        Arguments.of(95399.98, 89999.99, "NY", ShippingType.STANDARD),
        Arguments.of(105948.04, 99950.99, "IL", ShippingType.NEXT_DAY)
        //Invalid test on EquivalencePartitioning
    );
  }

}
