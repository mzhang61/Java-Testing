Feature: Total cost calculation:
  Scenario: The cost is 1, and standard shipping, state IL
    Given The initial cost is 1.00
    Given The state is "IL"
    Given The shipping fee is STANDARD
    Then The total cost is 11.06

  Scenario: The cost is 100, and standard shipping, state OW
    Given The initial cost is 100.00
    Given The state is "WOW"
    Given The shipping fee is STANDARD
    Then The total cost is 100

  Scenario: The cost is 5000, and standard shipping, state LateNightRush
    Given The initial cost is 5000.00
    Given The state is "LateNightRush"
    Given The shipping fee is STANDARD
    Then The total cost is 5000

