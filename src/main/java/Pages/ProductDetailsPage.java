package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage extends PageBase{

    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }


    @FindBy(id = "option-label-size-143-item-167")
    WebElement SizeSmall;

    @FindBy(id = "option-label-size-143-item-168")
    WebElement SizeMedium;

    @FindBy(id = "option-label-size-143-item-169")
    WebElement SizeLarge;

    @FindBy(id = "option-label-color-93-item-53")
    WebElement ColorGreen;

    @FindBy(id = "option-label-color-93-item-50")
    WebElement ColorBlue;

    @FindBy(id = "option-label-color-93-item-54")
    WebElement ColorLavender;

    @FindBy(id = "qty")
    WebElement Quantity;

    @FindBy(id = "product-addtocart-button")
    WebElement AddToCartButton;

    @FindBy(xpath = "//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")
    WebElement SuccessMessage;

    @FindBy(xpath = "//span[@class='counter-number']")
    WebElement CartCounter;

    @FindBy(css = "a.action.showcart")
    WebElement ShowCart;

    @FindBy(xpath = "//strong[@class='product-item-name']/a")
    WebElement CheckName;

    @FindBy(id = "top-cart-btn-checkout")
    WebElement ProceedToCheckout;


    public void SelectSize(String size){
        switch (size) {
            case "s", "S" -> clickWhenReady(SizeSmall, 5);
            case "m", "M" -> clickWhenReady(SizeMedium, 5);
            case "l", "L" -> clickWhenReady(SizeLarge, 5);
        }
    }

    public void SelectColor(String color){
        switch (color) {
            case "Blue", "blue" -> clickWhenReady(ColorBlue, 5);
            case "Green", "green" -> clickWhenReady(ColorGreen, 5);
            case "Lavender", "lavender" -> clickWhenReady(ColorLavender, 5);
        }
    }

    public void SetQuantity(String quantity){
        typeText(Quantity,quantity,3);
    }

    public void ClickOnAddToCart(){
        clickWhenReady(AddToCartButton,5);
    }

    public boolean isSuccessMessageVisible(){
        Scroll2Up();
        return isElementVisible(SuccessMessage,5);
    }

    public boolean isCartUpdated(String quantity){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(CartCounter, quantity));
        return true;
    }

    public void ClickOnCart(){
        clickWhenReady(ShowCart,5);
    }

    public boolean isProductNameCorrect(){
        return doesElementContainText(CheckName,"Marco Lightweight Active Hoodie",3);
    }

    public void Proceed2Checkout(){
        waitUntilVisible(ProceedToCheckout,10);
        clickWhenReady(ProceedToCheckout,15);
    }

}
