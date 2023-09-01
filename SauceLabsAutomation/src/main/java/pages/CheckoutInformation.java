package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;


public class CheckoutInformation {
    WebDriver driver;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorInfo;
    @FindBy(id = "first-name")
    WebElement firstNameCheckBox;

    @FindBy(id = "last-name")
    WebElement lastNameCheckBox;

    @FindBy(id = "postal-code")
    WebElement postalCodeCheckBox;
    @FindBy(id="continue")
    WebElement continueButton;
    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
    WebElement messegeError;

    public  CheckoutInformation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isErrorTextDisplayed(String error){
        String actualErrorMessage = errorInfo.getText();
        if(error.equalsIgnoreCase(actualErrorMessage)){
            return true;
        } else {
            return false;
        }
    }
    public void buy(String fname, String lname, String pCode){
        YourCartPage cartpage = new YourCartPage(DriverManager.getDriver().driver);
        cartpage.checkoutButtton.click();
        firstNameCheckBox.sendKeys(fname);
        lastNameCheckBox.sendKeys(lname);
        postalCodeCheckBox.sendKeys(pCode);
        continueButton.click();
    }
    public boolean isFailedBuy(String mError) {
        return messegeError.getText().equalsIgnoreCase(mError);
    }

}
