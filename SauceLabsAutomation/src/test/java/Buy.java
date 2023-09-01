import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;



import java.util.Dictionary;

public class Buy extends BaseTest{
    @Test
    public void makeABuyThatGivesWrongNumber() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");

        homePage.clickOnShoppingCartButton();

        CheckoutInformation information = new CheckoutInformation(DriverManager.getDriver().driver);
        information.buy("aa","aa","504");
        CheckoutOverview view = new CheckoutOverview(DriverManager.getDriver().driver);
        Thread.sleep(5000);
        long large = 59980000000000004L;
        if( large ==view.Precio2()){
            view.finishBuy();
            Assertions.assertTrue(view.isCompleteBuy());
        }

    }
    @Test
    public void makeABuyThatGivesWrongNumber2() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Onesie");

        homePage.clickOnShoppingCartButton();

        CheckoutInformation information = new CheckoutInformation(DriverManager.getDriver().driver);
        information.buy("aa","aa","504");
        CheckoutOverview view = new CheckoutOverview(DriverManager.getDriver().driver);
        Thread.sleep(5000);
        long large = 57980000000000004L;
        if(  large ==view.Precio2()){
            view.finishBuy();
            Assertions.assertTrue(view.isCompleteBuy());
        }

    }
    @Test
    public void makeABuyWithoutProducts() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.clickOnShoppingCartButton();

        CheckoutInformation information = new CheckoutInformation(DriverManager.getDriver().driver);
        information.buy("aa","aa","504");

        CheckoutOverview view = new CheckoutOverview(DriverManager.getDriver().driver);
        if(000 ==view.Precio()){
            view.finishBuy();
            Assertions.assertTrue(view.isCompleteBuy());
        }

    }
}
