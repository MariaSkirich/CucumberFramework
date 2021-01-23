package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelReading;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddEmployeeStepDefinition extends CommonMethods {
    @When("click on PIM")
    public void click_on_PIM() {
        dashboardPage.clickOnPIM();
    }

    @When("click on add employee button")
    public void click_on_add_employee_button() {
        dashboardPage.clickOnAddEmployee();
    }

    @Then("enter first and last name")
    public void enter_first_and_last_name() {
        addEmployeePage.enterFirstAndLastName("Rosalia", "Banks");
    }

    @Then("click on save button")
    public void click_on_save_button() {
        addEmployeePage.clickOnSaveBtn();
    }

    @Then("verify employee is added successfully")
    public void verify_employee_is_added_successfully() {
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", "Rosalia Banks", actualProfileName);
    }

    @Then("enter first name {string}, middle name {string}, and last name {string}")
    public void enter_first_name_middle_name_and_last_name(String firstName, String middleName, String lastName) {
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
    }

    @Then("verify that {string} is added successfully")
    public void verify_that_is_added_successfully(String fullName) {
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

    @When("enter {string}, {string} and {string}")
    public void enter_and(String firstName, String middleName, String lastName) {
        addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
    }

    @Then("verify {string}, {string} and {string} is added successfully")
    public void verify_and_is_added_successfully(String firstName, String middleName, String lastName) {
        String fullName = firstName + " " + middleName + " " + lastName;
        String actualProfileName = personalDetailsPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();

        for (Map<String, String> employeeName : employeeNames) {
            String firstName = employeeName.get("FirstName");
            String middleName = employeeName.get("MiddleName");
            String lastName = employeeName.get("LastName");
            String employeeID = employeeName.get("EmployeeID");

            addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
            addEmployeePage.enterEmployeeID(employeeID);
            addEmployeePage.clickOnSaveBtn();
            String actualFullName = personalDetailsPage.getUserProfileName();
            String expectedFullName = firstName + " " + middleName + " " + lastName;
            Assert.assertEquals("Verifying profile name", expectedFullName, actualFullName);
            dashboardPage.clickOnAddEmployee();
            Thread.sleep(5000);
        }

    }

    @When("add multiple employees from Excel {string} sheet and verify they are added")
    public void add_multiple_employees_from_Excel_sheet_and_verify_they_are_added(String sheetName) throws InterruptedException {
        List<Map<String, String>> excelData = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        for (Map<String, String> employeeName:excelData) {
            String firstName=employeeName.get("FirstName");
            String middleName=employeeName.get("MiddleName");
            String lastName=employeeName.get("LastName");
            String employeeID=employeeName.get("EmployeeID");

            addEmployeePage.enterFirstMiddleAndLastName(firstName, middleName, lastName);
            addEmployeePage.enterEmployeeID(employeeID);
            addEmployeePage.clickOnSaveBtn();
            String actualFullName = personalDetailsPage.getUserProfileName();
            String expectedFullName = firstName + " " + middleName + " " + lastName;
            Assert.assertEquals("Verifying profile name", expectedFullName, actualFullName);
            dashboardPage.clickOnAddEmployee();
            Thread.sleep(3000);

        }
    }
}
