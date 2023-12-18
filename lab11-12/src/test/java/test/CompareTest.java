package test;

import driver.DriverFactory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.ComparePage;
import page.ProductPage;
import page.BasePage;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CompareTest {
    private WebDriver driver;
    private ProductPage productPage;
    private ComparePage comparePage;
    private BasePage basePage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        productPage = new ProductPage(driver);
        comparePage = new ComparePage(driver);
        basePage= new BasePage(driver);
    }
    @Test
    public void testCompareProducts() {
        // Перейти на страницу первого товара
        driver.get("https://www.21vek.by/mobile/iphone11128gbmhdh3_apple.html");
        productPage.clickAcceptButton();
        basePage.waitSeconds(1);
        // Нажать "Добавить в сравнение"
        productPage.clickAddToCompareButton();
        basePage.waitSeconds(1);

        // Перейти на страницу второго товара
        driver.get("https://www.21vek.by/mobile/smart73gb64gbx6515_infinix_02.html");

        // Нажать "Добавить в сравнение"
        productPage.clickAddToCompareButton();
        basePage.waitSeconds(1);

        // Нажать "Сравнить товары"
        productPage.clickCompareButton();
        basePage.waitSeconds(1);

        // Проверить, что на странице сравнения присутствуют оба товара
        String product1 = "Смартфон Infinix Smart 7 3GB/64GB / X6515 (синий)";
        String product2 = "Смартфон Apple iPhone 11 128GB / MHDH3 (черный)";

        assert(comparePage.isProductPresent(product1));
        assert(comparePage.isProductPresent(product2));
    }

}
