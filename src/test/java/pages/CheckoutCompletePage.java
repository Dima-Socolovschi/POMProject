package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage{

    WebDriver driver;
    String url = "https://www.saucedemo.com/checkout-complete.html";

    //Locators
    By backHomeButtonLocator = By.id("back-to-products");
    By orderConfirmationLocator = By.xpath("//h2[@class='complete-header']");

    public CheckoutCompletePage(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public CheckoutCompletePage open(){
        driver.get(url);
        return this;
    }

    public CheckoutCompletePage waitPageIsLoaded(){
        isElementPresent(backHomeButtonLocator, "Checkout page one is not loaded.");
        return this;
    }

    public CheckoutCompletePage isTheOrderCompleted(){

        WebElement orderConfirmation = driver.findElement(orderConfirmationLocator);
        Assert.assertEquals(orderConfirmation.getText(), "Thank you for your order!");
        return this;
    }

}
