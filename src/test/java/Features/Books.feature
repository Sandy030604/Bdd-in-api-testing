Feature: Book API Managament

  Scenario: Create a new book
    Given Enter the post url
    And enter the book details
    When post the book details
    Then validate the status code
    And validate the book name
    And validate the price
    And Validate the Author


    Scenario: Get the book details
      Given Enter the url
      When get the book details
      Then validate the status code
      And validate the book name
      And validate the price
      And Validate the Author


      Scenario: Update put the book details
        Given Enter the url
        And enter updated book details
        When put the book details
        Then validate the status code
        And validate the book name
        And validate the price
        And Validate the Author

  Scenario: Update patch the book details
    Given Enter the url
    And enter updated book details
    When patch the book details
    Then validate the status code
    And validate the book name
    And validate the price
    And Validate the Author


    Scenario:Delete the book
      Given Enter the url
      Then validate the status code
