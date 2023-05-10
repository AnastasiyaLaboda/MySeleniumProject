package pageobject.onliner;

import org.openqa.selenium.By;
import pageobject.BasePage;

import static java.lang.String.format;

public class HomePage extends BasePage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'top-menu')]//*[contains(@class, 'main-navigation') and contains(text(), '%s')]";

    public boolean isMainNavigationSectionDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, title)));
    }

    public CatalogPage clickOnMainNavigationLink(String link) {
        waitForElementVisible(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, link))).click();
        return new CatalogPage();
    }
}
