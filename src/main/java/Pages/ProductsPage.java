package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class ProductsPage extends PageBase{

    private static final Logger log = LogManager.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "search")
    WebElement SearchBar;

    @FindBy(css = "button[type = 'submit']")
    WebElement SearchIcon;

    @FindBy(css = "a.product-item-link")
    List<WebElement> ProductNames;

    @FindBy(css = "a.action.next")
    WebElement NextPage;

    @FindBy(css = "a[href = 'https://magento.softwaretestingboard.com/marco-lightweight-active-hoodie.html']")
    WebElement HoodieProduct;

    public void Search(String item){
        SearchBar.sendKeys(item);
        SearchIcon.click();
    }

    public void waitForProductsToLoad(int timeoutSeconds) {
        Scroll2Bottom();
        waitUntilAllVisible(ProductNames, timeoutSeconds);
    }

    public void logAllProductsNames() {
        log.info("Logging all visible product names:");
        for (WebElement product : ProductNames) {
            log.info("→ [" + product.getText().trim() + "]");
        }
    }

    public boolean AreProductsMatched(String keyword){
        log.info("Verifying all products in the list contain the keyword: " + keyword);
        boolean All_Match = true;
        for(WebElement product : ProductNames){
            String name = product.getText().trim();
            if(!name.contains(keyword)){
                log.warn("Product name does not contain keyword: [" + name + "]");
                All_Match = false;
            }
        }
        if (!All_Match) {
            log.warn("Some product names did not match the keyword, but test will continue.");
        }
        return All_Match;
    }

    public void GoToNextPage(){
        Scroll2Bottom();
        clickWithJS(NextPage);
    }

    public void ClickOnProduct(){
        clickWithJS(HoodieProduct);
    }
}
