package com.it_academy.test.onliner;

import com.it_academy.test.BaseTest;
import constants.OnlinerUrls;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.onliner.CatalogPage;
import pageobject.onliner.HomePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CatalogCategorySectionTest extends BaseTest {
    private HomePage homePage;
    private static final String MAIN_SECTION_TITLE = "Каталог";
    private static final String[] CATALOG_CATEGORY_SECTION_NAMES = {"Электроника", "Компьютеры и сети", "Бытовая техника",
            "На каждый день", "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам"};

    @BeforeClass
    public void init() {
        homePage = new HomePage();
        homePage.open(OnlinerUrls.HOME.getUrl());
        homePage.clickOnMainNavigationLink(MAIN_SECTION_TITLE);
    }

    @Test
    public void verifyEachCatalogCategorySectionIsDisplayed() {
        assertThat(new CatalogPage().getCatalogCategorySectionsList())
                .as("Verify that each Catalog category section is displayed")
                .allMatch(element -> element.isDisplayed());
    }

    @Test
    public void verifyExactCatalogCategorySectionsAreExist() {
        assertThat(new CatalogPage().getCatalogCategorySectionsNames())
                .containsAll(List.of(CATALOG_CATEGORY_SECTION_NAMES));
    }
}