package com.it_academy.test.onliner;

import com.it_academy.test.BaseTest;
import constants.OnlinerUrls;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.onliner.CatalogPage;
import pageobject.onliner.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductGroupTest extends BaseTest {
    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Компьютеры";
    private static final String CATALOG_CATEGORY_SECTION = "Комплектующие";
    private static final String VALID_PRODUCTS_DESCRIPTION = "\\s*\\S*([\\d,]+)\\s*товар[а-я]*\\nот\\s([\\d,]+)\\sр\\s*\\S*";
    private static int PRODUCT_GROUP_COUNT;

    @BeforeClass
    public void init() {
        HomePage homePage = new HomePage();
        homePage.open(OnlinerUrls.HOME.getUrl());
        PRODUCT_GROUP_COUNT = homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY)
                .clickOnCatalogCategorySectionClassifierLink(CATALOG_CATEGORY_SECTION)
                .getProductGroupsList()
                .size();
    }

    @Test
    public void verifyInEachProductGroupValidNumberOfProductsAndMinPriceIsDisplayed() {
        assertThat(new CatalogPage().getProductGroupValuesList(CatalogPage.ProductGroupValues.NUMBER_OF_PRODUCTS_AND_MIN_PRICE))
                .hasSize(PRODUCT_GROUP_COUNT)
                .allSatisfy(
                        element -> {
                            assertThat(element.isDisplayed()).isTrue();
                            assertThat(element.getText()).matches(VALID_PRODUCTS_DESCRIPTION);
                        });
    }

    @Test
    public void verifyInEachProductGroupTitleIsDisplayed() {
        assertThat(new CatalogPage()
                .getProductGroupValuesList(CatalogPage.ProductGroupValues.TITLE))
                .hasSize(PRODUCT_GROUP_COUNT)
                .allMatch(element -> element.isDisplayed());
    }
}