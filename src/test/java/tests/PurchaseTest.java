package tests;

import Pages.Checkout_ReviewPage;
import Pages.Checkout_ShippingPage;
import Pages.Checkout_SuccessPage;
import Pages.ProductDetailsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.helpers;

public class PurchaseTest extends TestBase{

    ProductDetailsPage productDetails ;
    Checkout_ShippingPage shipping;
    Checkout_ReviewPage review;
    Checkout_SuccessPage success;
    helpers help;
    SoftAssert softAssert;

    @BeforeClass
    public void init(){
        productDetails = new ProductDetailsPage(driver);
        shipping = new Checkout_ShippingPage(driver);
        review = new Checkout_ReviewPage(driver);
        success = new Checkout_SuccessPage(driver);
        help = new helpers(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void Purchase(){
        help.addProductToCart("s","blue","2");
        shipping.enterEmail("kmagdy74@gmail.com");
        shipping.enterFirstname("karim");
        shipping.enterLastname("magdy");
        shipping.enterAddress("19 autoamtion street");
        shipping.enterCity("Cairo");
        shipping.enterZipCode("123456");
        shipping.enterCountry("Egypt");
        shipping.enterPhoneNumber("0123456789");
        shipping.enterShippingMethod();
        shipping.ClickOnNext();
        softAssert.assertTrue(review.isOrderSummaryVisible(),"Order Summary is not visible");
        review.Placeorder();
        softAssert.assertTrue(success.isSuccessMessageVisible(),"Success Message is not visible");
        softAssert.assertTrue(success.isOrderNoVisible(),"Order Number is not visible");
        softAssert.assertAll();
    }
}
