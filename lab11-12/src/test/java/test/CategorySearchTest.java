package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.SearchPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CategorySearchTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void testCategorySearch() {
        // Открываем домашнюю страницу
        driver.get("https://www.21vek.by/order/");
        homePage.clickAcceptButton();
        // Выполняем поиск по категории
        homePage.enterSearchQuery("Смартфон");
        searchPage.waitSeconds(5);
        int price = 7587;
        searchPage.enterPriceFilter(Integer.toString(price));
        searchPage.waitSeconds(1);
        searchPage.clickShowProductsButton();
        searchPage.waitSeconds(5);
        assertTrue(searchPage.getFoundProductPrice() >= price);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
