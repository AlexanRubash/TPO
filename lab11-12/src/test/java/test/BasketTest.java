package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.BasketPage;
import page.ProductPage;
import page.HomePage;

import static org.junit.Assert.assertEquals;

public class BasketTest {
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
    public void testAddToBasketAndCheck() {

        driver.get("https://www.21vek.by/mobile/iphone11128gbmhdh3_apple.html");
        basketPage.clickAcceptButton();
        basketPage.waitSeconds(1);
        productPage.clickAddToBasketButton();
        basketPage.waitSeconds(1);
        assertEquals("В корзине", productPage.checkBasketButton());
        basketPage.waitSeconds(1);
        homePage.clickBasketButton();
        basketPage.waitSeconds(1);
        String expectedProductTitle = "Смартфон Apple iPhone 11 128GB / MHDH3 (черный)";
        assertEquals(expectedProductTitle, basketPage.getProductTitle());

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
