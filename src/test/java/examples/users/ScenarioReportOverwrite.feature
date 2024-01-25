@feature-tag-correct
Feature: Reports from Sceanrios will be overwritten and Tags from the Example Section are missing 

  @scenario-tag-correct
  Scenario Outline: Just some random values for diffrent Results
    * def result = function() { var random = Math.random(); return random > 0.5; }()
    Given print "Example <Example>"
    Then match result == true

    @example-table-1-tag-missing
    Examples:
      | Example |
      | 1       |
      | 2       |
      | 3       |

    @example-table-2-tag-missing
    Examples:
      | Example |
      | 4       |
      | 5       |
      | 6       |
