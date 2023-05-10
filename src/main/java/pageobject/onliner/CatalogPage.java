package pageobject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BasePage;

import java.util.List;

import static java.lang.String.format;

public class CatalogPage extends BasePage {
    private static final String CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN =
            "//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text()) and contains(text(), '%s')]";
    private static final String CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and normalize-space(text())='%s']";
    private static final String PRODUCT_GROUP_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]"
                    + "//span[contains(@class, 'title') and contains(text(), '%s')]";

    private static final By catalogCategorySectionsLink =
            By.xpath("//ul[@class='catalog-navigation-classifier ']/li//span[normalize-space(text())]");
    private static final By catalogCategorySectionAsideTitlesLink
            = By.xpath("//div[contains(@class, 'aside_active')]//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title')]");
    private static final By productGroupsLink =
            By.xpath("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]");


    public enum ProductGroupValues {
        /** Enum class for product group values */
        TITLE("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]//span[contains(@class, 'title')]"),
        NUMBER_OF_PRODUCTS_AND_MIN_PRICE("//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]//span[contains(@class, 'description')]");
        private String xpath;

        ProductGroupValues(String xpath) {
            this.xpath = xpath;
        }

        public String getXPath() {
            return xpath;
        }
    }

    public boolean isCatalogCategorySectionTitlesDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN, title)));
    }

    public CatalogPage clickOnCatalogCategorySectionLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CATEGORY_SECTION_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public boolean isCatalogCategorySectionClassifierTitlesDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN, title)));
    }

    public CatalogPage clickOnCatalogCategorySectionClassifierLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CATEGORY_SECTION_CLASSIFIER_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public List<WebElement> getProductGroupValuesList(ProductGroupValues value) {
        return waitForExpectedElements(By.xpath(value.getXPath()));
    }

    public List<WebElement> getCatalogCategorySectionsList() {
        return waitForExpectedElements(catalogCategorySectionsLink);
    }

    public List<String> getCatalogCategorySectionsNames() {
        return getTextsFromWebElements(catalogCategorySectionsLink);
    }

    public List<WebElement> getProductGroupsList() {
        return waitForExpectedElements(productGroupsLink);
    }

    public ProductPage clickOnProductGroupLink(String productGroup) {
        waitForElementVisible(By.xpath(format(PRODUCT_GROUP_XPATH_PATTERN, productGroup)))
                .click();
        return new ProductPage();
    }

    //TODO заменить страшный локатор
    public List<WebElement> getAsideCatalogCategorySectionsTitles() {
        moveToElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div[1]"));
        return waitForExpectedElements(catalogCategorySectionAsideTitlesLink);
    }
}