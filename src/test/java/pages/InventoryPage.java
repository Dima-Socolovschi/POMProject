package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.transform.Source;
import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage{

    WebDriver driver;
    String url = "https://www.saucedemo.com/inventory.html";

    //Locators
    By cartPageLocator = By.xpath("//a[@class='shopping_cart_link']");
    By cartItemLocator = By.xpath("//div[@class='inventory_item']");
    By cartItemNameSelector = By.cssSelector("div.inventory_item_name ");

    public InventoryPage(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public InventoryPage open(){
        driver.get(url);
        return this;
    }

    public InventoryPage waitPageIsLoaded(){
        isElementPresent(cartPageLocator, "The page is not loaded.");
        return this;
    }

    public InventoryPage addItemToCart(String itemName) throws InterruptedException {

        List<WebElement> itemsList = driver.findElements(cartItemLocator);

        for(WebElement item : itemsList){
            if(item.findElement(cartItemNameSelector).getText().equals(itemName)){
                item.findElement(By.cssSelector("button")).click();
                break;
            }
        }

        return this;
    }
}
