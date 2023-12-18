package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.BasketPage;
import page.HomePage;
import page.ProductPage;
import static org.junit.Assert.assertEquals;

public class PromocodeTest {
    private WebDriver driver;
    private HomePage homePage;
    private BasketPage basketPage;
    private ProductPage productPage;
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        basketPage = new BasketPage(driver);
        productPage=new ProductPage(driver);
    }

    @Test
    public void testAddToBasketAndCheck() {
        // Перейти на страницу товара
        driver.get("https://www.21vek.by/mobile/iphone11128gbmhdh3_apple.html");
        homePage.clickAcceptButton();
// Нажать "В корзину"
        homePage.waitSeconds(2);
        productPage.clickAddToBasketButton();
        homePage.waitSeconds(2);
        homePage.clickBasketButton();

// Проверить, что продукт в корзине соответствует добавленному
        homePage.waitSeconds(2);
        basketPage.enterPromocodeQuery("amogus");
        homePage.waitSeconds(2);
        assertEquals("Промокод не действителен", basketPage.getPromocodeErrorMessage());

    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
