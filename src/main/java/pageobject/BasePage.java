package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static constants.WaitTimeouts.EXPLICIT_WAIT;
import static framework.DriverManager.getWebDriver;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {
    private final WebDriver driver;

    public BasePage() {
        driver = getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(getWebDriver(), ofSeconds(EXPLICIT_WAIT));
        return webDriverWait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(getWebDriver(), ofSeconds(EXPLICIT_WAIT));
        return webDriverWait.until(elementToBeClickable(by));
    }

    public void open(String url) {
        getWebDriver().get(url);
    }

    public String getBrowserTitle() {
        return getWebDriver().getTitle();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getWebDriver(), ofSeconds(EXPLICIT_WAIT));
            WebElement element = wait.until(visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Element " + locator + " was  not found on the page");
            return false;
        }
    }

    public List<WebElement> waitForExpectedElements(By by) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(getWebDriver(), ofSeconds(EXPLICIT_WAIT));
        return webDriverWait.until(presenceOfAllElementsLocatedBy(by));
    }

    public List<String> getTextsFromWebElements(By by) {
        Wait<WebDriver> webDriverWait = new WebDriverWait(getWebDriver(), ofSeconds(EXPLICIT_WAIT));
        return webDriverWait.until(presenceOfAllElementsLocatedBy(by)).stream().map(WebElement::getText).collect(toList());
    }

    public void moveToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
}
