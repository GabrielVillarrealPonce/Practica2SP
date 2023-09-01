import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import utilities.DriverManager;
public class CheckoutViewTests extends BaseTest {
    @Test
    public void removeAProductInCheckoutOverview() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();

        HomePage homePage = new HomePage(DriverManager.getDriver().driver);
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Bike Light");
        int numeror = Integer.parseInt(homePage.GetCartNumber());
        System.out.println(numeror);
        homePage.clickOnShoppingCartButton();

        CheckoutInformation information = new CheckoutInformation(DriverManager.getDriver().driver);
        information.buy("aa", "aa", "504");
        CheckoutOverview view = new CheckoutOverview(DriverManager.getDriver().driver);
        String nombre = view.EntrarElemento();
        homePage.removeProductFromCart(nombre);
        Thread.sleep(5000);
        view.BacktoProducts ();
        Assertions.assertTrue(homePage.DiffNumber(numeror));
        Thread.sleep(5000);

    }
}
