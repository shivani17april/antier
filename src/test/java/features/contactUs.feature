Feature: ContactUs

  Scenario: Verify User is able to submit the ContactUs form
    Given The user launches the application
    When  The user click on Contact Us link
    Then The user should be redirected to the contact us Page
    When The user enters the name
    And The user enters the country
#    And The user enters the contact number
#    And The user enters the contact number
