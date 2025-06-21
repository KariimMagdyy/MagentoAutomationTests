package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Checkout_ReviewPage extends PageBase{

    public Checkout_ReviewPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "button.action.primary.checkout")
    WebElement PlaceOrder;

    @FindBy(css = "span.title")
    WebElement OrderSummary;

    public void Placeorder(){
        waitUntilVisible(PlaceOrder,10);
        waitUntilClickable(PlaceOrder,10);
        clickWithJS(PlaceOrder);
    }

    public boolean isOrderSummaryVisible(){
        return doesElementContainText(OrderSummary,"Order Summary",20);
    }

}
