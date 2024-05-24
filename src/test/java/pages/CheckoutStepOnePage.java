package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOnePage extends BasePage{

    WebDriver driver;
    String url = "https://www.saucedemo.com/checkout-step-one.html";

    //Locators
    By firstNameLocator = By.xpath("//input[@name='firstName']");
    By lastNameLocator = By.xpath("//input[@name='lastName']");
    By postalCodeLocator = By.xpath("//input[@name='postalCode']");
    By continueLocator = By.xpath("//input[@name='continue']");

    public CheckoutStepOnePage(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public CheckoutStepOnePage open(){
        driver.get(url);
        return this;
    }

    public CheckoutStepOnePage waitPageIsLoaded(){
        isElementPresent(firstNameLocator, "Checkout page one is not loaded.");
        return this;
    }

    public CheckoutStepOnePage addFirstName(String firstName){
        WebElement firstNameField = driver.findElement(firstNameLocator);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CheckoutStepOnePage addLastName(String lastName){
        WebElement lastNameField = driver.findElement(lastNameLocator);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CheckoutStepOnePage addPostalCode(String password){
        WebElement postalCodeField = driver.findElement(postalCodeLocator);
        postalCodeField.clear();
        postalCodeField.sendKeys(password);
        return this;
    }

    public CheckoutOverviewPage clickOnContinueButton(){
        WebElement continueButton = driver.findElement(continueLocator);
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }



}
