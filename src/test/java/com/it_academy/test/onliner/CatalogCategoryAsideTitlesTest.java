package com.it_academy.test.onliner;

import com.it_academy.test.BaseTest;
import constants.OnlinerUrls;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.onliner.CatalogPage;
import pageobject.onliner.HomePage;


import static org.assertj.core.api.Assertions.assertThat;

public class CatalogCategoryAsideTitlesTest extends BaseTest {
    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String CATALOG_CATEGORY = "Компьютеры";

    private static final String[] CATALOG_CATEGORY_ASIDE_TITLES_NAMES = {"Ноутбуки, компьютеры, мониторы", "Комплектующие",
            "Техника для печати и дизайна", "Кассовые аппараты и торговое оборудование", "Манипуляторы и устройства ввода",
            "Хранение данных", "Мультимедиа периферия", "Сетевое оборудование", "Аксессуары к ноутбукам и компьютерам",
            "Электропитание", "Игры и программное обеспечение"};


    @BeforeClass
    public void init() {
        HomePage homePage = new HomePage();
        homePage.open(OnlinerUrls.HOME.getUrl());
        homePage
                .clickOnMainNavigationLink(MAIN_SECTION_TITLE)
                .clickOnCatalogCategorySectionLink(CATALOG_CATEGORY);
    }

    @Test
    public void verifyCategorySectionAllAsideTitlesAreDisplayedAndContainExactNames() {
        assertThat(new CatalogPage().getAsideCatalogCategorySectionsTitles())
                .allSatisfy(
                        element -> {
                            assertThat(element.isDisplayed()).isTrue();
                            assertThat(element.getText()).containsAnyOf(CATALOG_CATEGORY_ASIDE_TITLES_NAMES);
                        });
    }
}
