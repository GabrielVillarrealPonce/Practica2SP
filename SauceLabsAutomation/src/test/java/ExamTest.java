import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;



import java.util.Dictionary;
public class ExamTest extends BaseTest {

    @Test
    public void TestExamen() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");


        homePage.clickOnShoppingCartButton();

        YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
        Assertions.assertTrue(yourCartPage.isProductDisplayed("Sauce Labs Fleece Jacket"));
        Assertions.assertTrue(yourCartPage.isPriceDisplayed(4999));
        Assertions.assertTrue(yourCartPage.isProductDisplayed("Sauce Labs Bike Light"));
        Assertions.assertTrue(yourCartPage.isPriceDisplayed(999));

        Assertions.assertTrue(yourCartPage.isCartNumberCorrect("2"));

        homePage.removeProductFromCart("Sauce Labs Fleece Jacket");
        homePage.removeProductFromCart("Sauce Labs Bike Light");

        Assertions.assertFalse(yourCartPage.isProductDisplayed("Sauce Labs Fleece Jacket"));
        Assertions.assertFalse(yourCartPage.isProductDisplayed("Sauce Labs Bike Light"));

        Assertions.assertTrue(yourCartPage.isCartNumberCorrect(""));

    }

}
