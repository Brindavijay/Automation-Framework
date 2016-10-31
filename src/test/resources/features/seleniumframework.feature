Feature: Access iconitgroup.com website
  Use selenium java with cucumber-jvm and navigate to website

  Scenario: Print title, url
    When I open iconitgroup.com website
    Then I validate title and URL