package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        Driver.getDriver().get("http://qa1.vytrack.com");
    }

    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
        loginPage.login();
        Thread.sleep(3000);
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {

        String expected = "Dashboard";
        String actual = loginPage.getPageSubTitleText().trim();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");
        Driver.closeDriver();

        // LoginPage inherits  BasePage, so we can call detPageSubTitleText even
        // if BasePage is abstract (no obj)


    }

    @Then("user should see {string} page")
    public void user_should_see_page(String string) {

        String actual = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("Page title is not correct", string, actual);

    }



    // @parametrize_test , login as a driver
    // login as a salesmanager
    // login as a storemanager
    // When user logs in as a "store manager"
    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {

        loginPage.login(string);
    }

    //  When user logs in with "storemanager229" username and "wrong" password
    // String string = "storemanager229"
    // String string2 = "wrong"
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    // Then user verifies that "Invalid user name or password." message is displayed
    // String expected = "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult = loginPage.getWarningMessage();
        Assert.assertEquals(expected, actualResult);
    }
}