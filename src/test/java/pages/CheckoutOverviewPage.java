package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CheckoutOverviewPage extends BasePage{

    WebDriver driver;
    String url = "https://www.saucedemo.com/checkout-step-two.html";

    //Locators
    By finishButtonLocator = By.id("finish");
    By cartItemLocator = By.xpath("//div[@class='cart_item']");

    public CheckoutOverviewPage(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public CheckoutOverviewPage open(){
        driver.get(url);
        return this;
    }

    public CheckoutOverviewPage waitPageIsLoaded(){
        isElementPresent(finishButtonLocator, "Checkout page one is not loaded.");
        return this;
    }

    public CheckoutOverviewPage checkIfItemIsPresentInOverview(String itemName){

            List<WebElement> cartItems = driver.findElements(cartItemLocator);
            boolean isCartItemPresent = false;

            for(WebElement cartItem: cartItems){
                if(cartItem.getText().contains(itemName)){
                    isCartItemPresent = true;
                }
            }

            Assert.assertTrue(isCartItemPresent, "The item is not present in overview page.");

            return this;
    }

    public CheckoutCompletePage clickOnFinishButton(){
        WebElement finishButton = driver.findElement(finishButtonLocator);
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

}
