package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".g-basketbtn.j-button-clicked")
    private WebElement basketButton;

    @FindBy(id = "catalogSearch")
    private WebElement searchInput;

    @FindBy(css = ".error__number")
    private WebElement errorNumber;

    @FindBy(xpath = "//button[@class='styles_localityBtn__qrGFQ']")
    private WebElement geographyButton;

    @FindBy(xpath = "//input[@class='select__input']")
    private WebElement geographyInput;

    @FindBy(xpath = "//button[@class='Button-module__buttonText']")
    private WebElement geoSubmit;

    @FindBy(xpath = "//span[@class='ErrorMessage-module__message']")
    private WebElement geoError;

    @FindBy(css = ".ErrorViewWrapper_heading__jIxEN")
    private WebElement errorHeading;

    public void clickBasketButton() {
        logger.info("Нажатие на кнопку корзины.");
        basketButton.click();
    }

    public void enterSearchQuery(String query) {
        logger.info("Ввод запроса поиска: " + query);
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);
    }

    public String getErrorNumber() {
        logger.info("Получение номера ошибки.");
        return errorNumber.getText();
    }

    public String getErrorHeading() {
        logger.info("Получение заголовка ошибки.");
        return errorHeading.getText();
    }

    public void clickGeoButton() {
        logger.info("Нажатие на кнопку географии.");
        geographyButton.click();
    }

    public void inputGeo(String input) {
        logger.info("Ввод значения географии: " + input);
        geographyInput.clear();
        geographyInput.sendKeys(input);
        geographyInput.sendKeys(Keys.ENTER);
    }

    public String getGeoError() {
        logger.info("Получение ошибки географии.");
        return geoError.getText();
    }


}
