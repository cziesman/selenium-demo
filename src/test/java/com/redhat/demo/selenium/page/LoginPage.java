package com.redhat.demo.selenium.page;

import com.redhat.demo.selenium.helper.WebDriverHelper;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "submitLoginBtn")
    private WebElement loginButton;

    @After
    public void tearDown() {

        WebDriverHelper.tearDown();
    }

    public void setUserName(String email) {

        this.email.sendKeys(email);
    }

    public void setPassword(String password) {

        this.password.sendKeys(password);
    }

    public void clickLoginButton() {

        loginButton.click();
    }

    public String getTitle() {

        // retrieve the title dynamically as the DOM is being updated behind our backs.
        WebElement titleText = WebDriverHelper.getDriver().findElement(By.xpath("//*[text()='SHOPPING CART']"));

        return titleText.getText();
    }

    public String getErrorMessage() {

        // retrieve the error message dynamically as the DOM is being updated behind our backs.
        WebElement errorMessage = WebDriverHelper.getDriver().findElement(By.id("message"));

        return errorMessage.getText();
    }

    public boolean isValid() {

        assert email != null;
        assert password != null;
        assert loginButton != null;

        return true;
    }

}
