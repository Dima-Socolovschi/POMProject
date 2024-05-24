package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {

    WebDriver driver;
    String url = "https://www.saucedemo.com/cart.html";

    //Locators
    By titleLocator = By.xpath("//span[text()='Your Cart']");
    By cartItemsLocator = By.xpath("//div[@class='cart_item_label']");
    By cartItemNameLocator = By.xpath("//div[@class='inventory_item_name']");
    By checkoutButtonLocator = By.xpath("//button[@name='checkout']");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        driver = webDriver;
    }

    public CartPage open() {
        driver.get(url);
        return this;
    }

    public CartPage waitPageIsLoaded() {
        isElementPresent(titleLocator, "Cart page is not loaded.");
        return this;
    }

    public CartPage isItemPresentInTheCart(String itemName) {

        List<WebElement> cartItems = driver.findElements(cartItemsLocator);
        boolean isCartItemPresent = false;

        for(WebElement cartItem: cartItems){
            if(cartItem.getText().contains(itemName)){
                isCartItemPresent = true;
            }
        }

        Assert.assertTrue(isCartItemPresent, "The item is not present in the cart.");

        return this;
    }

    public CheckoutStepOnePage clickOnCheckoutButton(){

        WebElement checkoutButton = driver.findElement(checkoutButtonLocator);

        isElementPresent(checkoutButtonLocator, "Cannot proceed to checkout.");

        checkoutButton.click();

        return new CheckoutStepOnePage(driver);
    }

}
