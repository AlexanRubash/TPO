package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-testid='loginButton']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[@class='styles_userToolsToggler__c2aHe']")
    private WebElement accountButton;

    @FindBy(xpath = "//button[@class='Button-module__button userToolsBtn Button-module__blue-primary Button-module__small']")
    private WebElement enterButton;

    @FindBy(id = "login-email")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-testid='loginSubmit']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[@class='ErrorMessage-module__message' and text()='Неправильный формат электронной почты']")
    private WebElement errorMessage;

    public void clickAccountButton() {
        accountButton.click();
        logger.info("Нажатие на кнопку 'Аккаунт'.");
    }

    public void clickEnterButton() {
        enterButton.click();
        logger.info("Нажатие на кнопку 'Войти'.");
    }

    public void clickLoginButton() {
        loginButton.click();
        logger.info("Нажатие на кнопку 'Войти'.");
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        logger.info("Ввод электронной почты: '{}'", email);
    }

    public void clickSubmitButton() {
        submitButton.click();
        logger.info("Нажатие на кнопку 'Отправить'.");
    }

    public String getErrorMessageText() {
        String errorMessageText = errorMessage.getText();
        logger.info("Получено сообщение об ошибке: '{}'", errorMessageText);
        return errorMessageText;
    }
}
