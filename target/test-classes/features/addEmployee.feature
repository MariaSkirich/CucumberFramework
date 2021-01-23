Feature: Add Employee Functionality

  Background:
    When enter valid credentials
    And click on login button
    Then verify Dashboard is displayed
    When click on PIM
    And click on add employee button

  @addEmployeeWithoutLogin
  Scenario: Add employee without login details
    Then enter first and last name
    And click on save button
    Then verify employee is added successfully

  @addEmployeeWithLogin
  Scenario: Add employee with login credentials and with middle name
    Then enter first and last name and middle name
    When click on login details checkbox
    Then enter login details
    And click on save button
    Then verify employee is added successfully

  @parameter
  Scenario: Add employee without login details but with middle name
    Then enter first name "Marta", middle name "Mary", and last name "Ostash"
    And click on save button
    Then verify that "Marta Mary Ostash" is added successfully

  @examples
  Scenario Outline: Adding employees without login details
    When enter "<FirstName>", "<MiddleName>" and "<LastName>"
    And click on save button
    Then verify "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples:
      | FirstName | MiddleName | LastName |
      | Mark      | Jay        | Smith    |
      | James     | Kay        | Brown    |

  @dtWithHeader
  Scenario: Adding multiple employees at one execution
    When add multiple employees and verify they are added successfully
      | FirstName | MiddleName | LastName | EmployeeID |
      | Mike      | Jay        | White    | 5464987646 |
      | Dave      | Drew       | Becks    | 2132216879 |

  @excelTask
  Scenario: Adding multiple employees from Excel
    When add multiple employees from Excel "AddEmployee" sheet and verify they are added