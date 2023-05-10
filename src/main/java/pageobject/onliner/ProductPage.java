package pageobject.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BasePage;

import java.util.List;

public class ProductPage extends BasePage {
    private final By productLink = By.xpath("//div[@class='schema-product__group']");

    public enum ProductDetails {
        TITLE(By.xpath("//div[@class='schema-product__group']//span[contains(@data-bind, 'product.full_name')]")),
        DESCRIPTION(By.xpath("//div[@class='schema-product__group']//span[contains(@data-bind, 'product.description')]")),
        RATING(By.xpath("//div[@class='schema-product__group']//span[contains(@class, 'rating__fill')]")),
        PRICE(By.xpath("//div[@class='schema-product__group']//span[contains(@data-bind, 'prices')]")),
        IMAGINE(By.xpath("//div[@class='schema-product__group']//*[contains(@class, 'image-link')]")),
        CHECKBOX(By.xpath("//div[@class='schema-product__group']//label[contains(@class, 'control')]"));
        private By productDetailBy;

        public By getProductDetailBy() {
            return productDetailBy;
        }

        ProductDetails(By by) {
            this.productDetailBy = by;
        }
    }

    public List<WebElement> getProductsList() {
        return waitForExpectedElements(productLink);
    }

    public List<WebElement> getProductsDetailsList(ProductDetails detail) {
        return waitForExpectedElements(detail.getProductDetailBy());
    }
}

