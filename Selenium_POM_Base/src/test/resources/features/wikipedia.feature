Feature: Wikipedia test

  as wikipedia user i want to validate world searching in wikipedia page


  Scenario Outline: Validate word searching

    Given  User can navegate to principal wikipedia Page
    When   Search word "<word>"
    Then   Then validate if tittle is "<wordToValidate>"


    Examples:
      | word  | wordToValidate |
      | Arepa | Arepa          |
      | Arepa | Arepita        |




