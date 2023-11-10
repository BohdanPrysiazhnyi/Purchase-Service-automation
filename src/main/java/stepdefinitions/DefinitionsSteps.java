package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DefinitionsSteps {
    @Given("User opens start page")
    public void userOpensLoginPage(){

    }

    @When("User click on HFN login button")
    public void userClickOnHFNLoginButton() {
    }

    @And("User click on Login text field and enter {string}")
    public void userClickOnLoginTextFieldAndEnter(String login) {
    }

    @And("User click on Password text field and enter {string}")
    public void userClickOnPasswordTextFieldAndEnter(String password) {
    }
}
