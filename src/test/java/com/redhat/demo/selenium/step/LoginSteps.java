package com.redhat.demo.selenium.step;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import com.redhat.demo.selenium.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {

    private static final Logger LOG = LoggerFactory.getLogger(LoginSteps.class);

    private final LoginPage page = new LoginPage();

    @Given("User is on QA Practice Login Shop page {string}")
    public void user_is_on_qa_practice_login_shop_page(String url) {

        LOG.info("{}", url);
        WebDriverHelper.openPage(url, page);

        Assertions.assertTrue(page.isValid());
    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {

        LOG.info("{} {}", email, password);

        page.setUserName(email);
        page.setPassword(password);
        page.clickLoginButton();
    }

    @Then("User should be able to login successfully and new page {string} opens")
    public void user_should_be_able_to_login_successfully_and_new_page_open(String pageTitle) {

        String title = page.getTitle();

        LOG.info("{}", title);
        Assertions.assertEquals(pageTitle, title);
    }

    @Then("User should be able to see error message {string}")
    public void user_should_be_able_to_see_error_message(String errorMessage) {

        String error = page.getErrorMessage();

        LOG.info("{}", error);
        Assertions.assertEquals(errorMessage, error);
    }

}
