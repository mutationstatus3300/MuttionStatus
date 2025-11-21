@Register
Feature: Register Feautre

  Background: 
    Given User perfroms operation in background step

  Scenario Outline: Register with First and Last Name
    Given User is on the Register page
    When User enters first name as "<firstName>" and last name as "<lastName>"

    Examples: 
      | firstName | lastName |
      | Abhishek  | Singh    |
      | Sunil     | Singh    |
      | Suresh    | Aditya   |
      | Suresh    | kohli    |
