# @All
Feature: Login Page feature

 @Smoke
  Scenario Outline: Login with Valid Credential using Examples and placeholder
    Given user navigates to Guru99Bank url
    When user enters "<username>" and "<password>"
    And click on Submit
    Then user on the Manager Home Page 
    And Verify ManagerId is "<ManagerId>" display on the manager home page

    Examples: 
      | username  | password | ManagerId  |
      | mngr355479 | EjUtamE | mngr355479 |
      | mngr355479 | EjUtamE | mngr355479 |      

# @Smoke
  Scenario: Login with Valid Credential using datatable and parameter
    Given user navigates to Guru99Bank url
    When user enters following data
		|mngr355479|EjUtamE|
		|mngr355479|EjUtamE|
    And click on Submit
    Then user on the Manager Home Page 
    And Verify ManagerId is "mngr355479" display on the manager home page

# 	@Smoke
  Scenario: Login with Valid Credential using datatable with column name and parameter
    Given user navigates to Guru99Bank url
    When user enters following data with column name
    |username|password|
		|mngr355479|EjUtamE|
    And click on Submit
    Then user on the Manager Home Page 
    And Verify ManagerId is "mngr355479" display on the manager home page
	
 	@Smoke
  Scenario: Login with Invalid Credential
    Given user navigates to Guru99Bank url
    When user enters "nirav" and "nirav234"
    And click on Submit
    Then Verify Alert Message for invalid username and password
      