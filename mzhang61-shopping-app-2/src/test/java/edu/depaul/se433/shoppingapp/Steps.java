package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Steps {

  private double initialCost = 0;
  private String state = "";
  private String shippingfee = "";
  private TotalCostCalculator cal = new TotalCostCalculator();

  @Given("The initial cost is {double}")
  public void The_initial_cost_is(Double double1) {
    initialCost = double1;
  }

  @Given("The state is {string}")
  public void The_state_is(String arg0) {
    state = arg0;
  }

  @Given("The shipping fee is {word}")
  public void shipping_fee(String type1) {
    shippingfee = type1;
  }

  @Then("The total cost is {double}")
  public void The_total_cost_is(double expectedCost) {
    double first = cal.calculate(initialCost, state, ShippingType.valueOf(shippingfee));
    assertEquals(expectedCost, first);
  }
}
