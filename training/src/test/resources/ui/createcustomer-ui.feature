 Feature: Create Customer with all mandatory details
 
 Scenario: Create Customer with mandatory details
    When the Customer is created with Details
    | Joey | Tribbiani | Male | 0091-3233333112 | joeyt@gmail.com | ALP234444  | Beverly Hills | Los Angeles | 98777 | United States  | Savings | 10000 |
    Then customer is created successfully