Feature: create update delete or hours to a project

  Scenario: create hours to a resource
    Given a resource id 14 who works 3 hours in the task 190
    When save the hours
    Then the resource id 14 has 3 hours assigned in the task 190

  Scenario: create negative hours to a resource
    Given a resource id 19 who works -3 hours in the task 150
    When save the hours
    Then i get invalid number error

  Scenario: create zero hours to a resource
    Given a resource id 19 who works 0 hours the task 150
    When save the hours
    Then i get invalid number error

  Scenario: create more than 24 hours to a resource
    Given a resource id 22 who works the task 148
    When add 25 hours to the resource id 22
    Then i get invalid number error

  Scenario: assign a hours worked to a task
    Given a resource id 15 who works 2 hours in a task 350
    When i assign the hours to the task 350
    Then the resource id 15 has 2 hours assigned to a task 350

  Scenario: update hours from a resource
    Given a resource id 17 with 3 hours assigned to a task 350
    When i modify the task 350
    Then the resource id 17 has 3 hours assigned to the new task 174

  Scenario: delete hours worked from a task
    Given a resource id 4 with 10 hours worked from a task 204
    When i delete 2 hours from the task 204
    Then the resource id 4 has 8 hours assigned to the task 204

  Scenario: confirm the delete of hours
    Given a resource id 154 with 10 hours worked from a task 154
    When i delete 2 hours from the resource id 154 task 154
    Then the system ask me to confirm