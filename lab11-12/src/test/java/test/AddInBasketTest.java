package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.BasketPage;
import page.ProductPage;
import page.HomePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.Assert.assertEquals;

public class AddInBasketTest {
    private static final Logger logger = LogManager.getLogger(AddInBasketTest.class);
    private WebDriver driver;
    private ProductPage productPage;
    private BasketPage basketPage;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        basketPage = new BasketPage(driver);
        productPage = new ProductPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testAddInBasket() {
        logger.info("Starting the test testAddInBasket");
        driver.get("https://www.21vek.by/mobile/iphone11128gbmhdh3_apple.html");
        basketPage.clickAcceptButton();
        basketPage.waitSeconds(2);
        productPage.clickAddToBasketButton();
        basketPage.waitSeconds(2);
        homePage.clickBasketButton();
        basketPage.waitSeconds(1);
        basketPage.clickIncreaseQuantityButton();
        basketPage.waitSeconds(4);
        String expectedProductTitle = "Смартфон Apple iPhone 11 128GB / MHDH3 (черный)";
        assertEquals(true, basketPage.clickIncreaseQuantityButton());


    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
