package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(BasketPage.class);

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".BasketItem_titleWrapper__ytawc a.BasketItem_title__MzCQ9")
    private WebElement productTitle;

    @FindBy(xpath = "//div[@class='EmptyBasket_text__3fMyR']")
    private WebElement emptyBasketText;

    @FindBy(xpath = "//input[@class='BaseInput-module__input']")
    private WebElement promocodeInput;

    @FindBy(xpath = "//span[@class='ErrorMessage-module__message']")
    private WebElement promocodeErrorMessage;

    public String getProductTitle() {
        logger.info("Получение заголовка продукта в корзине.");
        return productTitle.getText();
    }

    public String getPromocodeErrorMessage() {
        logger.info("Получение сообщения об ошибке для промокода.");
        return promocodeErrorMessage.getText();
    }

    public void enterPromocodeQuery(String query) {
        logger.info("Ввод запроса промокода: " + query);
        promocodeInput.clear();
        promocodeInput.sendKeys(query);
        promocodeInput.sendKeys(Keys.ENTER);
    }

    @FindBy(xpath = "//button[@aria-label='Увеличение количества']")
    private WebElement increaseQuantityButton;

    @FindBy(css = "input.Counter_counterInput__idJlc")
    private WebElement quantityInput;

    public boolean clickIncreaseQuantityButton() {
        int count_a = Integer.parseInt(quantityInput.getAttribute("value"));
        increaseQuantityButton.click();
        int count_b = Integer.parseInt(quantityInput.getAttribute("value"));

        logger.info("Увеличение количества товара в корзине.");
        return count_b > count_a;
    }

    public String emptyBasketCheck() {
        logger.info("Проверка текста пустой корзины.");
        return emptyBasketText.getText();
    }
}
