package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class InventoryPage{

    private final SelenideElement addToCart = $(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));
    private final SelenideElement cartIcon = $(By.className("shopping_cart_link"));

    public InventoryPage waitPageIsLoaded(){
        addToCart.should(Condition.clickable);
        return this;
    }

    public InventoryPage addBagToCart(){
        addToCart.click();
        return this;
    }

    public CartPage navigateToCart(){
        cartIcon.click();
        return new CartPage();
    }
}
