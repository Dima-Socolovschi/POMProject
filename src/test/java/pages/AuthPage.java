package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage{

    private final SelenideElement usernameLocator = $(By.id("user-name"));
    private final SelenideElement passwordLocator = $(By.id("password"));
    private final SelenideElement loginLocator = $(By.id("login-button"));

    public AuthPage waitPageIsLoaded(){
        Allure.step("Wait till the page is open");
        usernameLocator.should(Condition.appear);
        return this;
    }

    public AuthPage enterUsername(String username){

        Allure.step("Enter Username");

        usernameLocator.should(Condition.visible, Duration.ofSeconds(2));
        usernameLocator.clear();
        usernameLocator.sendKeys(username);
        return this;
    }

    public AuthPage enterPassword(String password){

        Allure.step("Enter Password");

        usernameLocator.should(Condition.visible, Duration.ofSeconds(2));
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        return this;
    }

    public InventoryPage clickToLogin(){

        Allure.step("Click on login button");

        loginLocator.should(Condition.clickable, Duration.ofSeconds(2));
        loginLocator.click();
        return new InventoryPage();
    }
}
