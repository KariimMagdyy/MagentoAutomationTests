package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout_ShippingPage extends PageBase{

    public Checkout_ShippingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "customer-email")
    WebElement email;

    @FindBy(name = "firstname")
    WebElement firstname;

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "street[0]")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "postcode")
    WebElement zipcode;

    @FindBy(name = "country_id")
    WebElement country;

    @FindBy(name = "telephone")
    WebElement phoneNumber;

    @FindBy(name = "ko_unique_2")
    WebElement ShippingMethod;

    @FindBy(css = "button.action.continue.primary")
    WebElement Next;

    public void enterEmail(String Email){
        typeText(email,Email,3);
    }

    public void enterFirstname(String FirstName){
        typeText(firstname,FirstName,10);
    }

    public void enterLastname(String LastName){
        typeText(lastname,LastName,3);
    }

    public void enterAddress(String Address){
        typeText(address,Address,3);
    }

    public void enterCity(String City){
        typeText(city,City,3);
    }

    public void enterZipCode(String Zipcode){
        typeText(zipcode,Zipcode,3);
    }

    public void enterCountry(String country_choice){
        selectByText(country,country_choice,3);
    }

    public void enterPhoneNumber(String PhoneNo){
        typeText(phoneNumber,PhoneNo,3);
    }

    public void enterShippingMethod(){
        clickWhenReady(ShippingMethod,3);
    }

    public void ClickOnNext(){
        clickWhenReady(Next,3);
    }
}
