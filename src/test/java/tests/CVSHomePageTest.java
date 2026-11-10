
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.CVSHomePage;

public class CVSHomePageTest {

    WebDriver driver;
    CVSHomePage cvsHomePage;

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        cvsHomePage = new CVSHomePage(driver);
    }

    @Test
    public void verifyCVSHomepageHeadline() {

        cvsHomePage.openCVSWebsite();

        boolean result =
            cvsHomePage.isHeadlineDisplayed();

        Assert.assertTrue(
            result,
            "Expected CVS headline was not displayed"
        );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
