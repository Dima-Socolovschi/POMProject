package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage{

    private final SelenideElement bagItem = $(By.id("item_4_title_link"));

    public void isBagIsPresent(){
        bagItem.should(Condition.appear);
    }

}
