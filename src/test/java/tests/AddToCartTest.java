package tests;

import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartTest extends TestBase{
    ProductsPage products;
    ProductDetailsPage productDetails;
    SoftAssert softAssert;

    @BeforeClass
    public void init(){
        products = new ProductsPage(driver);
        productDetails = new ProductDetailsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void AddProductsToCart(){
        products.ClickOnProduct();
        productDetails.SelectSize("M");
        productDetails.SelectColor("lavender");
        productDetails.SetQuantity("5");
        productDetails.ClickOnAddToCart();
        softAssert.assertTrue(productDetails.isSuccessMessageVisible(),"Success Message is not visible when adding products to cart");
        softAssert.assertTrue(productDetails.isCartUpdated("5"),"Cart is not updated with the quantity added");
        productDetails.ClickOnCart();
        softAssert.assertTrue(productDetails.isProductNameCorrect(),"Product Name is not displayed correctly");
        softAssert.assertAll();
    }
}
