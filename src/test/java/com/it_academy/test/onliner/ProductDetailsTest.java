package com.it_academy.test.onliner;

import com.it_academy.test.BaseTest;
import com.it_academy.test.listeners.AllureReportListener;
import constants.OnlinerUrls;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.onliner.HomePage;
import pageobject.onliner.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(AllureReportListener.class)
public class ProductDetailsTest extends BaseTest {

    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Электроника";
    private static final String CATALOG_CATEGORY_SECTION = "Аудиотехника";
    private static final String PRODUCT_GROUP = "Наушники";

    private static int PRODUCT_COUNT;

    @BeforeClass
    public void init() {
        HomePage homePage = new HomePage();
        homePage.open(OnlinerUrls.HOME.getUrl());
        PRODUCT_COUNT = homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY)
                .clickOnCatalogCategorySectionClassifierLink(CATALOG_CATEGORY_SECTION)
                .clickOnProductGroupLink(PRODUCT_GROUP)
                .getProductsList()
                .size();
    }

    @DataProvider(name = "productDetailsName")
    public static Object[][] provideProductDetailName() {
        ProductPage.ProductDetails[] productDetails = ProductPage.ProductDetails.values();
        Object[][] dataProvider = new Object[productDetails.length][1];
        for (int i = 0; i < productDetails.length; i++) {
            dataProvider[i][0] = productDetails[i];
        }
        return dataProvider;
    }

    @Test(dataProvider = "productDetailsName")
    public void verifyInEachProductDetailedInformationIsDisplayed(ProductPage.ProductDetails name) {
        assertThat(new ProductPage().getProductsDetailsList(ProductPage.ProductDetails.valueOf(String.valueOf(name))))
                .hasSizeGreaterThanOrEqualTo(PRODUCT_COUNT)
                .allMatch(element -> element.isDisplayed());
    }
}
