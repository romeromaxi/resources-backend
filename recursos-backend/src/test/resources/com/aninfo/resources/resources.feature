Feature: reading resources from external system

  Scenario: reading resources from external system
  Given there is an external system with three resources
  When reading the resources from the external system
  Then I get a list with 3 elements