import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Sleeper;
import pages.*;
import utilities.DriverManager;

import java.util.List;

public class HomeTests extends BaseTest {

    @Test
    public void addProductsToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        Thread.sleep(5000);
        Assertions.assertTrue(homePage.isDesplayedCartBadge());
    }
    @Test
    public void removeProductsFromCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        System.out.println(homePage.getProductPrice("Sauce Labs Fleece Jacket"));
        homePage.removeProductFromCart("Sauce Labs Fleece Jacket");
        YourCartPage cartpage = new YourCartPage(DriverManager.getDriver().driver);
        cartpage.isCartNumberCorrect("");

    }
    @Test
    public void resetAppState() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.clickOnBurgerButton();
        homePage.clickOnResetLink();
        List<String> estado = homePage.btnInventoryS();
        Assertions.assertTrue(homePage.verifyReset(estado));
    }


}
