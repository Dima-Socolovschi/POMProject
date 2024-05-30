package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthPage;

import java.time.Duration;

public class TestStore extends BaseTest {

    @DataProvider(name="LoginDataProvider")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user","secret_sauce","Sauce Labs Bike Light"},
                {"locked_out_user","secret_sauce","Test"}
        };
    }

    @Test(dataProvider = "LoginDataProvider")
    @Description("Basic test to check the functional.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Dimas")
    public void addToCartTest(String login, String password, String productName){

        AuthPage authPage = new AuthPage();

        Allure.addAttachment("Username", login);
        Allure.addAttachment("Password", password);
        Allure.addAttachment("Product Name", productName);

        authPage
                .waitPageIsLoaded()
                .enterUsername(login)
                .enterPassword(password)
                .clickToLogin()
                .waitPageIsLoaded();
    }
}
