import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;
public class CheckoutInformationTest extends BaseTest {
    @Test
    public void enterEmptyFirstName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        CheckoutInformation information = new CheckoutInformation(DriverManager.getDriver().driver);
        information.buy("", "aa", "504");

        Assertions.assertTrue(information.isErrorTextDisplayed("Error: First Name is required"));
    }
    @Test
    public void enterEmptyLastName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        CheckoutInformation information = new CheckoutInformation(DriverManager.getDriver().driver);
        information.buy("GABO", "", "504");

        Assertions.assertTrue(information.isErrorTextDisplayed("Error: Last Name is required"));
    }
    @Test
    public void enterEmptyPostalCode() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        CheckoutInformation information = new CheckoutInformation(DriverManager.getDriver().driver);
        information.buy("GABO", "Villarreal", "");

        Assertions.assertTrue(information.isErrorTextDisplayed("Error: Postal Code is required"));
    }
}
