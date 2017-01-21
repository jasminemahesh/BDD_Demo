 Feature: Retrieve Customer details
 
 Scenario: Retrieve Customer details for valid Customer Id
    Given the search criteria is "valid" customerid "1"
    When the "searchById" button is clicked
    Then the customer details for 1 is retrieved
    
Scenario: Retrieve Customer details for invalid Customer Id
    Given the search criteria is "invalid" customerid "24444"
    When the "searchById" button is clicked
    Then the error User Not Found is shown
    

    
    
    
    
   