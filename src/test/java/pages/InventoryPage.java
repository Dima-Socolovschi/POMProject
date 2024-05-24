package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage{

    WebDriver driver;
    String url = "https://www.saucedemo.com/inventory.html";

    //Locators
    By cartPageLocator = By.xpath("//a[@class='shopping_cart_link']");
    By itemLocator = By.xpath("//div[@class='inventory_item']");
    By itemNameLocator = By.xpath("//div[@class='inventory_item_name']");
    By addToCartLocator = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");


    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(url);
    }

    public void waitPageIsLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(cartPageLocator));
    }

    public void addItemToCart(String itemName){

        List<WebElement> allElements = driver.findElements(itemNameLocator);

        for(WebElement element : allElements){
            if(element.findElements()getText().equals(itemName)){
                element.findElements(addToCartLocator);
            }
        }
    }

}
