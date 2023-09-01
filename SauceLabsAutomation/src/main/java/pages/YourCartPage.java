package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourCartPage {
    WebDriver driver;
    @FindBy(className = "shopping_cart_link")
    WebElement cartNumber;
    @FindBy(id = "checkout")
    WebElement checkoutButtton;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> price;
    public void Checkout(){checkoutButtton.click();};

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isCartNumberCorrect(String text)
    {
        if(cartNumber.getText().equalsIgnoreCase(text)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isProductDisplayed(String product){
        for (WebElement element: productNames) {
            if(element.getText().equalsIgnoreCase(product)){
                return true;
            }
        }
        return false;
    }

    public boolean isPriceDisplayed(long product){
        for (WebElement element: price) {
            String priceText = element.getText().replaceAll("[^0-9]", "");
            long priceValue = Long.parseLong(priceText);
            System.out.println(priceValue);
            if(priceValue == product){
                return true;
            }
        }
        return false;
    }

    public void removeProduct(String product){
        //sauce-labs-bike-bight
        //remove-
        String productLowerCase = product.toLowerCase();
        productLowerCase = productLowerCase.replace(" ", "-");
        String removeProductId = "remove-"+productLowerCase;
        WebElement removeButton = driver.findElement(By.id(removeProductId));
        removeButton.click();
    }
}
