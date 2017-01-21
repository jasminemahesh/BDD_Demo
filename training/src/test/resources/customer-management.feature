Feature: Create Customer
     
    Scenario: Customer Service Officer creates the Customer
    When Create Customer with firstname "John"
    Then A Customer named "John" has been created
