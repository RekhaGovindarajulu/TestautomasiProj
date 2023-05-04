Feature: Verify search function with different courses
  
  Scenario: Scenario Outline: Verify the search course flow
    Given User is on the testautomasi homepage
    When User clicks on E-learning link
    Then User is navigated to course page
    When User searches a particular course "<coursename>"
    Then The title of the course should contain "<coursename>"
    When User clicks on viewmore button
    And User clicks on Buy Now
    Then User is navigated to checkout page
    
    Examples: 
      | coursename | 
      | Jmeter |      
      | Selenium |
      | Appium | 