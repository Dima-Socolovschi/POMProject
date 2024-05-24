package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    //Locators
    By cartButton = By.xpath("//div[@id='shopping_cart_container']");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public BasePage waitTillElementIsLoaded(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    public BasePage waitTillElementIsClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }

    public BasePage isElementPresent(By locator, String message){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e){
            Assert.fail(message);
        }

        return this;
    }

    //Should this be here?
    public CartPage clickOnCartButton(){
        isElementPresent(cartButton, "Cart button is not present.");
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

}
