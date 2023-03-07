Feature: Talk to experts

  Scenario: Verify User is able to submit the Query Talk to our experts form
    Given The user launches the application
    When  The user click on Talk to our experts link
#    Then The user should be redirected to the Talk to expert Page
    Then The user enter the name
    When   The user enters the email
    And   The user enters the country
    And   The user enters the phone number
    And   The user enters the Message
    And   The user submit the form data


