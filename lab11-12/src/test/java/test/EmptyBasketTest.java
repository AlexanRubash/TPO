package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.BasketPage;
import page.HomePage;
import page.ProductPage;

import static org.junit.Assert.assertEquals;

public class EmptyBasketTest {
    private BasketPage basketPage;
    private WebDriver driver;
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        basketPage = new BasketPage(driver);
    }
    @Test
    public void testEmptyBasket() {
        basketPage.waitSeconds(2);
        driver.get("https://www.21vek.by/order/");
        //basketPage.clickAcceptButton();
        basketPage.waitSeconds(3);
        String emptyBasketText = basketPage.emptyBasketCheck();
        basketPage.waitSeconds(3);
        assertEquals("У вас пока нет ни одного товара в корзине,\n" +
                "вы можете выбрать их здесь", emptyBasketText);
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
