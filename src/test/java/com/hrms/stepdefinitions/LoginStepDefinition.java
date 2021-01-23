package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {
    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
    setUp();
    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
    loginPage.login("Admin", "Hum@nhrm123");
    }

    @When("click on login button")
    public void click_on_login_button() {
    loginPage.clickOnLoginButton();
    }

    @Then("verify Dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        Assert.assertTrue(dashboardPage.welcomeMessage.isDisplayed());
    }

    @And("quit the browser")
    public void quitTheBrowser() {
        tearDown();
    }

    @When("enter invalid credentials")
    public void enter_invalid_credentials() {
        loginPage.login("Admin23", "Hum@nhrm12354");
    }

    @Then("verify error message")
    public void verify_error_message() {
    Assert.assertEquals("Verifying error message","Invalid credentials", loginPage.getErrorMessage());
    }

    @When("leave username empty")
    public void leaveUsernameEmpty() {
    loginPage.login("", "Hum@nhrm123");
    }

    @Then("verify error message for empty username")
    public void verifyErrorMessageForEmptyUsername() {
    Assert.assertEquals("Verifying error message with empty username","Username cannot be empty",loginPage.getErrorMessage());
    }

    @When("leave password empty")
    public void leavePasswordEmpty() {
    loginPage.login("Admin", "");
    }

    @Then("verify error message for empty password")
    public void verifyErrorMessageForEmptyPassword() {
    Assert.assertEquals("Verifying error message with empty password","Password cannot be empty",loginPage.getErrorMessage());
    }
}
