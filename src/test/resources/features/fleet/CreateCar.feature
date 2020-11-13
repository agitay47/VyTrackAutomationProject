# group features based on components
  # we login as a store manager
Feature: As a user, I want to be able to create new cars

  @add_car @smoke
  Scenario: 1. Add some car
    Given user is on the landing page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks ob create cat button
    When user adds new vehicle information
      # parameter name and value
      | License Plate| SDET |
      | Model Year   | 2021 |
    And user clicks on save and close button


  @add_car_scenario_outline
  Scenario Outline: 1. Add some car with <license plate> plates and <model year> year
    Given user is on the landing page
    And user logs in as a "<role>"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks ob create cat button
    When user adds new vehicle information
      # parameter name and value
      | License Plate| <license plate> |
      | Model Year   | <model year> |
    And user clicks on save and close button

    Examples: auto test data
      |license plate|model year|role         |
      |FLORIDA      |2020      |store manager|
      |QA           |2021      |sales manager|
      |Alita        |2019      |store manager|
