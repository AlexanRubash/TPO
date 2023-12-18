package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='compare__link g-pseudo_href j-compare']")
    private WebElement addToCompareButton;

    @FindBy(xpath = "//a[@class='compare__link cr-compare__result j-compare_result']")
    private WebElement compareButton;

    @FindBy(xpath = "//button[@class='g-button g-buybtn item__buybtn cr-buybtn__in j-ga_track']")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//a[@class='j-button-clicked g-basketbtn']")
    private WebElement checkBasketButton;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement getProductTitle;

    public void clickAddToCompareButton() {
        logger.info("Нажатие на кнопку 'Добавить к сравнению'.");
        addToCompareButton.click();
    }

    public void clickCompareButton() {
        logger.info("Нажатие на кнопку 'Сравнить'.");
        compareButton.click();
    }

    public String checkBasketButton() {
        logger.info("Проверка текста на кнопке корзины.");
        return checkBasketButton.getText();
    }

    public void clickAddToBasketButton() {
        logger.info("Нажатие на кнопку 'Добавить в корзину'.");
        addToBasketButton.click();
    }

    public String getProductTitleText(){
        return getProductTitle.getText();
    }
}
