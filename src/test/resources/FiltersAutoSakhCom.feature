Feature: Auto.sakh.com

  Background:
    Given The user is on Auto.sakh.com page

  @hooks
    @close
  Scenario Outline:
    When Click to car brand filter
    And Choose car brand '<brand>'
    And Click find
    Then Filters return right list of cars '<brand>'
    Examples:
      | brand  |
      | Toyota |
      | Nissan |
      | Lada   |
      | Honda  |

  Scenario Outline:
    When Click to car brand filter
    And Choose car brand '<brand>'
    And Click to car model filter
    And Choose car model '<model>'
    And Click find
    Then Filters return right list of cars '<brand>' '<model>'
    Examples:
      | brand      | model  |
      | Toyota     | Auris  |
      | Nissan     | Note   |
      | Mitsubishi | Pajero |
      | Subaru     | XV     |

  Scenario Outline:
    When Click to car brand filter
    And Choose car brand '<brand>'
    And Click to car year from filter
    And Choose car year from '<yearFrom>'
    And Click to car year before filter
    And Choose car year before '<yearBefore>'
    And Click find
    Then Filters return right list of cars '<brand>' '<yearFrom>' '<yearBefore>'
    Examples:
      | brand      | yearFrom | yearBefore |
      | Toyota     | 2015     | 2020       |
      | Nissan     | 2010     | 2017       |
      | Mitsubishi | 2000     | 2012       |
      | Subaru     | 1990     | 2009       |
