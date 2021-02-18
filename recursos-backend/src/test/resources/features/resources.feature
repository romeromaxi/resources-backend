Feature: reading resources from external system

  Scenario: reading resources from external system
  Given there is an external system with three resources
  When reading the resources from the external system
  Then I get a list with 3 elements

  Scenario: reading a specific resource from the external system
  Given there is a resource in the external system with id 1
  When recovering the resource with id 1 from the external system
  Then I get the resource with id 1

  Scenario: reading a non-existent resource from the external system
  Given there is not a resource with id 4
  When trying to recover the resource with id 4
  Then I get resource not found error