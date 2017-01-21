Feature: Get Customer

 Scenario: Get Customer By Customer Id
    When Get the Customer with Customer Id 1
    Then A Customer with Customer Id 1 is retrieved
    
  Scenario: client makes call to GET /customer/get/id
    When the client calls /customer/get/1
    Then the get customer receives status code of 200
    
  Scenario: client makes call to GET /customer/list
    When the client calls /customer/list
    Then the get list of customers receives status code of 200