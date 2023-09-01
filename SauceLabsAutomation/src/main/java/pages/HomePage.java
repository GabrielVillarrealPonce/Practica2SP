package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    @FindBy(className = "btn_inventory")
    List<WebElement> btninventory;
    @FindBy(className = "shopping_cart_link")
    WebElement cartNumber;
    @FindBy(className = "app_logo")
    WebElement pageTitle;

    @FindBy(className = "product_sort_container")
    WebElement sortComboBox;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerButton;
    @FindBy(className = "inventory_details_price")
    WebElement productPrice;
    @FindBy(id = "back-to-products")
    WebElement backtoProducts;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public List btnInventoryS(){
        List<String> estado = new ArrayList<>();
        for( WebElement element: btninventory){
            System.out.println(element.getText());
            estado.add(element.getText());
        }
        return estado;
    }
    public void click(String nombreP){
        List<WebElement> elements = driver.findElements(By.className("inventory_item_name"));
        for( WebElement element: elements){
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase(nombreP)){
                element.click();
                break;
            }
        }
    }
    public boolean isDisplayedBackToproducts(){return backtoProducts.isDisplayed();}
    public void backToProductsClick(){backtoProducts.click();}
    public boolean isDesplayedCartBadge(){
        return cartNumber.isDisplayed();
    }
    public boolean pageTitleIsDisplayed(){
        boolean pageTitleIsDisplayed= pageTitle.isDisplayed();
        return pageTitleIsDisplayed;
    }
    public boolean verifyReset(List<String> estados) {
        for (String estado : estados) {
            if (!estado.equals("Add to cart")) {
                return false;
            }
        }
        return true;
    }
    public void selectSortComboBox(String option){
        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText(option);
    }

    public boolean areProductsInDescendantOrderByName(){
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List<String> actualProductNames = new ArrayList<>();

        for( WebElement element: products){
            actualProductNames.add(element.getText());
        }

        boolean isSorted = Ordering.natural().reverse().isOrdered(actualProductNames);

        if(isSorted){
            return true;
        } else {
            return false;
        }

    }

    public void addProductToCart(String productName){
        //sauce-labs-fleece-jacket
        // id button = add-to-cart-sauce-labs-fleece-jacket
        String productNameLowerCase = productName.toLowerCase();
        productNameLowerCase = productNameLowerCase.replace(" ","-");
        String addToCartId = "add-to-cart-";
        addToCartId = addToCartId + productNameLowerCase;

        WebElement addToCartButton = driver.findElement(By.id(addToCartId));
        addToCartButton.click();
    }

    public void removeProductFromCart(String productName){
        //sauce-labs-fleece-jacket
        // id button = add-to-cart-sauce-labs-fleece-jacket
        String productNameLowerCase = productName.toLowerCase();
        productNameLowerCase = productNameLowerCase.replace(" ","-");
        String removeFromCardId = "remove-";
        removeFromCardId = removeFromCardId + productNameLowerCase;

        WebElement removeFromCardButton = driver.findElement(By.id(removeFromCardId));
        removeFromCardButton.click();
    }
    public String GetCartNumber()
    {
        return cartNumber.getText();
    }
    public boolean DiffNumber(int numeroAN){
        int numeroAC = Integer.parseInt(cartNumber.getText());
        if(numeroAC < numeroAN){
            return true;
        }
        else{
            return false;
        }
    }

    public void clickOnShoppingCartButton(){
        shoppingCartButton.click();
    }

    public void clickOnBurgerButton(){
        burgerButton.click();
    }
    public void clickOnResetLink(){
        WebElement logoutLink = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link")));
        logoutLink.click();
    }
    public void clickOnLogoutLink(){
        WebElement logoutLink = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
    }
    public float getProductPrice(String name){
        float price = 0;
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        for( WebElement element: products){
            if(element.getText().toString()==name){
                element.click();
                String priceText = productPrice.getText().replaceAll("[^0-9.]", "");
                price = Float.parseFloat(priceText);
            }
        }
        return price;
    }
}
