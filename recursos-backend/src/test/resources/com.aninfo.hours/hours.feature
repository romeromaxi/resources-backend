Feature: create update delete or hours to a project

  Scenario: create hours to a resource
    Given a resource who works in a task
    When create 3 hours to the resource
    Then the resource has 3 hours assigned

  Scenario: create negative hours to a resource
    Given a resource who works in task
    When add -3 hours to the resource
    Then i get an error message

  Scenario: assign a hours worked to a task
    Given a resource who works 2 hours in a task
    When i assign the hours to the task
    Then the resource has 2 hours assigned to a task

  Scenario: update hours from a resource
    Given a resource with 3 hours assigned to a task
    When i modify the task
    Then the resource has 3 hours assigned to the new task

  Scenario: delete hours worked from a task
    Given a resource with 10 hours worked from a task
    When i delete 2 hours from the task
    Then the resouce has 8 assigned to the task

  Scenario: confirm the delete of hours
    Given a resource with 10 hours worked from a task
    When i delete 2 hours from the task
    Then the system ask me to confirm