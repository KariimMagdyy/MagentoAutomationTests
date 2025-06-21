package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_SuccessPage extends PageBase {

    public Checkout_SuccessPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#maincontent > div.page-title-wrapper > h1 > span")
    WebElement SuccessMessage;

    @FindBy(css = "div.checkout-success")
    WebElement orderNo;

    public boolean isSuccessMessageVisible(){
        waitForUrlToContain("success",20);
        waitUntilVisible(SuccessMessage,10);
        return SuccessMessage.isDisplayed();
    }

    public boolean isOrderNoVisible(){
        return doesElementContainText(orderNo,"Your order # is: ",10);
    }
}
