package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LoginPage;
import page.SearchPage;
import page.BasePage;
import page.HomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testProductSearch() {
        driver.get("https://www.21vek.by/order");
        homePage.waitSeconds(2);

        homePage.clickAcceptButton();
        homePage.waitSeconds(1);

        // Введите запрос в поле поиска
        homePage.enterSearchQuery("Apple");
        homePage.waitSeconds(1);

        // Проверьте, что найденный продукт отображается
        WebElement resultLink = driver.findElement(By.cssSelector(".result__link"));
        assertTrue(resultLink.isDisplayed());

        // Проверьте, что найденный продукт содержит слово "Apple"
        String resultProductName = driver.findElement(By.cssSelector(".result__name")).getText();
        assertTrue(resultProductName.contains("Apple"));

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
