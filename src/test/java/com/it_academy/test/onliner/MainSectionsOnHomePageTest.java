package com.it_academy.test.onliner;

import com.it_academy.test.BaseTest;
import constants.OnlinerUrls;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.onliner.HomePage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MainSectionsOnHomePageTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void navigationToHomePage() {
        homePage = new HomePage();
        homePage.open(OnlinerUrls.HOME.getUrl());
    }

    @DataProvider(name = "mainSectionsTitles")
    public Object[][] provideMainSectionsTitles() {
        return new Object[][]{{"Каталог"}, {"Новости"}, {"Автобарахолка"}, {"Дома и квартиры"},
                {"Услуги"}, {"Барахолка"}, {"Форум"}};
    }

    @Test(dataProvider = "mainSectionsTitles")
    public void testIsMainSectionsOnHomePageExists(String title) {
        assertThat(homePage.isMainNavigationSectionDisplayed(title))
                .as("Main navigation section " + title.toUpperCase() + " is not displayed")
                .isTrue();
    }
}
