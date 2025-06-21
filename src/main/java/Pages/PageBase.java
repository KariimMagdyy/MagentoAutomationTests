package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class PageBase {
    WebDriver driver;
    JavascriptExecutor js;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Internal reusable wait for visibility
    public WebElement waitUntilVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitUntilAllVisible(List<WebElement> elements, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // Internal reusable wait for clickability
    public WebElement waitUntilClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForUrlToContain(String keyword, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.urlContains(keyword));
    }


    public boolean isElementVisible(WebElement element, int timeoutInSeconds) {
        try {
            return waitUntilVisible(element, timeoutInSeconds).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public String getElementText(WebElement element, int timeoutInSeconds) {
        try {
            return waitUntilVisible(element, timeoutInSeconds).getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return "";
        }
    }

    public boolean doesElementContainText(WebElement element, String expectedText, int timeoutInSeconds) {
        return getElementText(element, timeoutInSeconds).contains(expectedText);
    }

    public void clickWhenReady(WebElement element, int timeoutInSeconds) {
        waitUntilClickable(element, timeoutInSeconds).click();
    }

    public void typeText(WebElement element, String text, int timeoutInSeconds) {
        WebElement input = waitUntilVisible(element, timeoutInSeconds);
        input.clear();
        input.sendKeys(text);
    }

    public void selectByText(WebElement dropdownElement,String text,int timeoutInSeconds) {
        dropdownElement = waitUntilVisible(dropdownElement,timeoutInSeconds);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(text);
    }

    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void Scroll2Bottom(){
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void Scroll2Up(){
        js.executeScript("window.scrollTo(0, 0);");
    }



}
