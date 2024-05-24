package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPage extends BasePage{

    WebDriver driver;

    String url = "https://www.saucedemo.com/";

    // Locators
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By loginLocator = By.id("login-button");

    public AuthPage(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public AuthPage open(){
        driver.get(url);
        return this;
    }

    public AuthPage waitPageIsLoaded(){
        isElementPresent(usernameLocator, "Authentication page is not loaded.");
        return this;
    }

    public AuthPage enterUsername(String username){
        WebElement usernameFld = driver.findElement(usernameLocator);
        usernameFld.clear();
        usernameFld.sendKeys(username);
        return this;
    }

    public AuthPage enterPassword(String password){
        WebElement passwordFld = driver.findElement(passwordLocator);
        passwordFld.clear();
        passwordFld.sendKeys(password);
        return this;
    }

    public InventoryPage clickToLogin(){
        driver.findElement(loginLocator).click();
        return new InventoryPage(driver);
    }
}
