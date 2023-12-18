package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.BasePage;

import static org.junit.Assert.assertEquals;

public class InvalidEmailFormatTest {
    private WebDriver driver;
    private BasePage basePage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        basePage= new BasePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testInvalidEmailFormat() {
        driver.get("https://www.21vek.by/order/");
        basePage.waitSeconds(2);
        basePage.clickAcceptButton();
        basePage.waitSeconds(2);
        loginPage.clickAccountButton();
        basePage.waitSeconds(2);
        loginPage.clickEnterButton();
        basePage.waitSeconds(2);
        // Введите некорректный адрес электронной почты
        loginPage.enterEmail("invalid-email");
        basePage.waitSeconds(2);
        // Нажмите кнопку Войти
        loginPage.clickSubmitButton();
        basePage.waitSeconds(2);
        // Проверьте, что отображается сообщение об ошибке
        String errorMessage = loginPage.getErrorMessageText();
        assertEquals("Неправильный формат электронной почты", errorMessage);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
