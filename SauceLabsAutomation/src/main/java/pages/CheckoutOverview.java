package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

import java.util.List;

public class CheckoutOverview {
    WebDriver driver;
    @FindBy(id = "back-to-products")
    WebElement backtoproductsButton;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;
    @FindBy(id="finish")
    WebElement finishButton;
    @FindBy(id="back-to-products")
    WebElement backButton;
    @FindBy(className = "summary_total_label")
    WebElement totalprice;
    @FindBy(className = "summary_subtotal_label")
    WebElement subtotal;

    public CheckoutOverview(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int Precio(){
        String priceText = totalprice.getText().replaceAll("[^0-9]", ""); // Elimina caracteres no numéricos
        int priceValue = Integer.parseInt(priceText);
        System.out.println(priceValue);
        return priceValue;

    }
    public void BacktoProducts(){backtoproductsButton.click();}
    public String EntrarElemento()
    {
        WebElement element = driver.findElements(By.className("inventory_item_name")).get(1);
        String nombre = element.getText();
        System.out.println(nombre);
        element.click();
        return nombre;
    }
    public long Precio2() {
        String priceText = subtotal.getText().replaceAll("[^0-9]", "");
        long priceValue = Long.parseLong(priceText);
        System.out.println(priceValue);
        return priceValue;
    }
    public void finishBuy() {
        finishButton.click();
    }
    public boolean isCompleteBuy() {
        return backButton.isDisplayed();
    }


}
