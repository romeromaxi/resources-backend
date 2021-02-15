Feature: create update delete or hours to a project

  Scenario: create hours to a resource
    Given a resource id 14 who works 3 hours in the task 190
    When save the hours
    Then the resource id 14 has 3 hours assigned in the task 190

  Scenario: create negative hours to a resource
    Given loading -3 hours to the resource with id 19 in the task 150
    When trying to save the hours
    Then i get invalid number error

  Scenario: create zero hours to a resource
    Given loading 0 hours to the resource with id 19 in the task 150
    When trying to save the hours
    Then i get invalid number error

  Scenario: create more than 24 hours to a resource
    Given loading 25 hours to the resource with id 19 in the task 150
    When trying to save the hours
    Then i get invalid number error

  Scenario: update task from the hours of a resource
    Given a resource id 15 with 3 hours on 20210115 assigned to task 244
    When i modify the task to 174
    Then the resource id 15 has 3 hours assigned to the new task 174

  Scenario: update date from the hours of a resource
    Given a resource id 15 with 4 hours on 20210115 assigned to task 244
    When i modify the date to 20210114
    Then the date of the 4 hours assigned to resource id 15 to task 244 is 20210114

  Scenario: update hours worked from a task
    Given a resource id 4 with 10 hours loaded on 20210115 from a task 244
    When i modify the quantity of worked hours to 5
    Then the resource id 4 has 5 hours assigned in the task 244

  Scenario: create hours to a resource saves loading date
    Given a resource id 14 who works 3 hours in the task 190
    When save the hours
    Then the loading date is today

  Scenario: delete hours
    Given a resource id 4 with 10 hours loaded on 20210115 from a task 244
    When delete the hours
    Then hours have been deleted

  #Scenario: confirm the delete of hours
  #  Given a resource id 154 with 10 hours worked from a task 154
  #  When i delete 2 hours from the resource id 154 task 154
  #  Then the system ask me to confirm