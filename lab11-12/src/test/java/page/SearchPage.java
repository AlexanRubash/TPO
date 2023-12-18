package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(SearchPage.class);

    @FindBy(css = ".ProductItem_title__qJCTw span")
    private WebElement foundProduct;

    @FindBy(css = ".g-item-data.j-item-data-real8644230")
    private WebElement productPrice;

    @FindBy(xpath = "//input[@name='filter[price][from]']")
    private WebElement priceInput;

    @FindBy(xpath = "//button[@id='j-filter__btn']")
    private WebElement showProductsButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFoundProductText() {
        String productText = foundProduct.getText();
        logger.info("Текст найденного продукта: '{}'", productText);
        return productText;
    }

    public double getFoundProductPrice() {
        String priceText = productPrice.getAttribute("content");
        double productPrice = Double.parseDouble(priceText);
        logger.info("Цена найденного продукта: '{}'", productPrice);
        return productPrice;
    }

    public void enterPriceFilter(String price) {
        priceInput.clear();
        priceInput.sendKeys(price);
        logger.info("Введено значение фильтра по цене: '{}'", price);
    }

    public void clickShowProductsButton() {
        showProductsButton.click();
        logger.info("Нажата кнопка 'Показать товары'");
    }
}
