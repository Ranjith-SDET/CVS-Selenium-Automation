
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CVSHomePage {

    WebDriver driver;
    WebDriverWait wait;

    public CVSHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(30)
        );
    }

    String url = "https://www.cvshealth.com/";

    String expectedText =
        "Building a world of health around every individual";

    public void openCVSWebsite() {
        driver.get(url);
    }

    public boolean isHeadlineDisplayed() {

        By headline = By.xpath(
            "//*[contains(normalize-space(.), '" +
            expectedText + "')]"
        );

        try {
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(headline)
            );
            return true;

        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
