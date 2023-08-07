package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setUp() {
        setChromeDriverPath();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomePageTitle() {
        driver.get("http://example.com");
        Assert.assertEquals(driver.getTitle(), "Example Domain");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void setChromeDriverPath() {
        String os = System.getProperty("os.name").toLowerCase();
        String chromeDriverPath;

        if (os.contains("win")) {
            chromeDriverPath = "src/main/resources/chromedriver/chromedriver.exe";
        } else if (os.contains("mac")) {
            chromeDriverPath = "src/main/resources/chromedriver/chromedriver";
        } else {
            throw new IllegalArgumentException("Unsupported operating system");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }
}
