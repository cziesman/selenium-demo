package com.redhat.demo.selenium.page;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddToCartPage {

    private static final Logger LOG = LoggerFactory.getLogger(AddToCartPage.class);

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submitLoginBtn")
    public WebElement loginButton;

    @After
    public void tearDown() {

        WebDriverHelper.tearDown();
    }

    public String getTitle() {

        // retrieve the title dynamically as the DOM is being updated behind our backs.
        WebElement titleText = WebDriverHelper.getDriver().findElement(By.xpath("//*[text()='SHOPPING CART']"));

        return titleText.getText();
    }

    public void clickAddToCartButton() {

        // retrieve the first ADD TO CART button dynamically.
        WebElement addToCartButton = WebDriverHelper.getDriver().findElement(By.xpath("//*[text()='ADD TO CART']"));

        addToCartButton.click();
    }

    public String getRemoveButton() {

        // retrieve the first ADD TO CART button dynamically.
        WebElement removeButton = findRemoveButton();

        return removeButton.getText();
    }

    public void clickRemoveButton() {

        // retrieve the first ADD TO CART button dynamically.
        WebElement removeButton = findRemoveButton();

        removeButton.click();
    }

    public boolean removeButtonIsNotPresent() {

        WebElement removeButton = null;
        try {
            removeButton = findRemoveButton();
        } catch (NoSuchElementException t) {
            // we expect this exception if the REMOVE button is gone
        }

        return removeButton == null;
    }

    protected WebElement findRemoveButton() {

        return WebDriverHelper.getDriver().findElement(By.xpath("//*[text()='REMOVE']"));
    }

}
