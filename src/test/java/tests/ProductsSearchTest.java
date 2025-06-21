package tests;

import Pages.PageBase;
import Pages.ProductsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsSearchTest extends TestBase {
    ProductsPage products;
    SoftAssert softAssert;

    @BeforeClass
    public void init(){
        products = new ProductsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void SearchForProduct(){
        products.Search("Hoodie");
        products.waitForProductsToLoad(3);
        products.logAllProductsNames();
        softAssert.assertTrue(products.AreProductsMatched("Hoodie"));
        products.GoToNextPage();
        products.logAllProductsNames();
        softAssert.assertTrue(products.AreProductsMatched("Hoodie"));
        softAssert.assertAll();
    }
}
