package test;

import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.HomePage;
import page.ProductPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ViewedTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testViewedProducts() {
        List<String> productsText = new ArrayList<>();

        driver.get("https://www.21vek.by/mobile/iphone11128gbmhdh3_apple.html");
        homePage.clickAcceptButton();
        homePage.waitSeconds(1);
        productsText.add(productPage.getProductTitleText());

        driver.get("https://www.21vek.by/mobile/smart73gb64gbx6515_infinix_02.html");
        homePage.waitSeconds(1);
        productsText.add(productPage.getProductTitleText());

        driver.get("https://www.21vek.by/mobile/hot30i8gb128gbx669d_infinix_01.html");
        homePage.waitSeconds(1);
        productsText.add(productPage.getProductTitleText());

        driver.get("https://www.21vek.by/tires/artmotionsnow14718565r1486t_belshina.html");
        homePage.waitSeconds(1);
        productsText.add(productPage.getProductTitleText());

        //driver.get("https://www.21vek.by/refrigerators/atlant_4208000.html");
        driver.get("https://www.21vek.by/viewed/");

        List<WebElement> viewedProducts = driver.findElements(By.cssSelector("div.OldProductCard_name__q8eRK a"));

        for (WebElement viewedProduct : viewedProducts) {
            String viewedProductText = viewedProduct.getText();
           assertTrue("Текст не совпадает: " + viewedProductText,
                    productsText.contains(viewedProductText));

        }
    }


    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
