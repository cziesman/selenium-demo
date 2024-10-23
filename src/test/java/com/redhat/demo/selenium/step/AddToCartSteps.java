package com.redhat.demo.selenium.step;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import com.redhat.demo.selenium.page.AddToCartPage;
import com.redhat.demo.selenium.page.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddToCartSteps {

    private static final Logger LOG = LoggerFactory.getLogger(AddToCartSteps.class);

    private AddToCartPage addToCartPage;

    @Given("User has logged on to the QA Practice Login Shop page {string} with email {string} and password {string}")
    public void user_has_logged_on_to_the_qa_practice_login_shop_page_with_email_and_password(String url, String email, String password) {

        LoginPage loginPage = new LoginPage();

        LOG.info("{}", url);
        WebDriverHelper.openPage(url, loginPage);

        Assertions.assertTrue(loginPage.isValid());

        LOG.info("{} {}", email, password);

        loginPage.setUserName(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    @When("User adds the Apple iPhone 12, 128GB, Black to their shopping cart on the {string} page")
    public void user_adds_the_apple_i_phone_128gb_black_to_their_shopping_cart(String pageTitle) {

        addToCartPage = new AddToCartPage();

        String title = addToCartPage.getTitle();

        LOG.info("{}", title);
        Assertions.assertEquals(pageTitle, title);

        addToCartPage.clickAddToCartButton();
    }

    @Then("User can see the {string} button for the Apple iPhone 12, 128GB, Black in their shopping cart")
    public void user_can_see_the_apple_i_phone_128gb_black_in_their_shopping_cart(String buttonTitle) {

        String remove = addToCartPage.getRemoveButton();
        Assertions.assertEquals(buttonTitle, remove);

        addToCartPage.clickRemoveButton();
        Assertions.assertTrue(addToCartPage.removeButtonIsNotPresent());
    }

}
