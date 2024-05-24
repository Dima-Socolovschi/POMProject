package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;

import java.time.Duration;

public class TestStore extends BaseTest {

    @Test
    public void addToCartTest() throws InterruptedException {

        AuthPage authPage = new AuthPage(driver);
        String itemName = "Sauce Labs Bike Light";

        authPage
                .open()
                .waitPageIsLoaded()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickToLogin()
                .waitPageIsLoaded()
                .addItemToCart(itemName)
                .clickOnCartButton()
                .waitPageIsLoaded()
                .isItemPresentInTheCart(itemName)
                .clickOnCheckoutButton()
                .waitPageIsLoaded()
                .addFirstName("Vasea")
                .addLastName("Pupkin")
                .addPostalCode("12021")
                .clickOnContinueButton()
                .waitPageIsLoaded()
                .checkIfItemIsPresentInOverview(itemName)
                .clickOnFinishButton()
                .waitPageIsLoaded()
                .isTheOrderCompleted();
    }
}
