package utils;

import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class helpers {

    WebDriver driver;
    ProductsPage products;
    ProductDetailsPage productDetails;

    public helpers(WebDriver driver) {
        this.driver = driver;
        this.products = new ProductsPage(driver);
        this.productDetails = new ProductDetailsPage(driver);
    }

    public void addProductToCart(String size, String color, String quantity) {
        products.ClickOnProduct();
        productDetails.SelectSize(size);
        productDetails.SelectColor(color);
        productDetails.SetQuantity(quantity);
        productDetails.ClickOnAddToCart();
        productDetails.isCartUpdated(quantity);
        productDetails.ClickOnCart();
        productDetails.Proceed2Checkout();
    }
}
