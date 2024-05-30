package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    public void setUpDriver() {
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://www.saucedemo.com";
        open("/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if(!result.isSuccess()){
            Allure.addAttachment("Screenshot: ", new ByteArrayInputStream (Selenide.screenshot(OutputType.BYTES)));
        }
        WebDriverRunner.getWebDriver().close();
    }

}
