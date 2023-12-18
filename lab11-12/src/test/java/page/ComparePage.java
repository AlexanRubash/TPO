package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(ComparePage.class);

    @FindBy(xpath = "//a[@class='mindbox-pr-view']")
    private WebElement productBlock;

    public ComparePage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPresent(String productName) {
        String xpathExpression = "//a[contains(@class, 'mindbox-pr-view') and contains(text(), '" + productName + "')]";
        boolean isPresent = isElementPresent(By.xpath(xpathExpression));

        if (isPresent) {
            logger.info("Продукт '{}' присутствует на странице сравнения.", productName);
        } else {
            logger.info("Продукт '{}' отсутствует на странице сравнения.", productName);
        }

        return isPresent;
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
