package com.e2eautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class App
{
    public static void main(String[] args) throws InterruptedException {
        // Set path to ChromeDriver executable
        setChromeDriverPath();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Navigate to Google
        driver.get("http://www.google.com");
        Thread.sleep(2000);

        // Find the search box element and enter a query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        Thread.sleep(2000);
        searchBox.submit();
        Thread.sleep(8000);

        // Print the title of the current page
        System.out.println("Page title is: " + driver.getTitle());

        // Find all the links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Print the total number of links
        System.out.println("Total number of links: " + links.size());

        // Print the URLs of all links
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            System.out.println(url);
            // Todo also print link name in console.
            //  getText() methods from WebElement class returns Text inside the web element

        }

        // Navigate back
        driver.navigate().back();
        Thread.sleep(2000);

        // Navigate forward
        driver.navigate().forward();
        Thread.sleep(2000);

        //todo get current browser url and print in console.

        // Close the browser
        driver.quit();
    }



    public static void setChromeDriverPath() {
        String os = System.getProperty("os.name").toLowerCase();
        String chromeDriverPath;

        if (os.contains("win")) {
            chromeDriverPath = App.class.getClassLoader().getResource("chromedriver.exe").getPath() ;
        } else if (os.contains("mac")) {
            chromeDriverPath = App.class.getClassLoader().getResource("chromedriver").getPath();
        } else {
            throw new IllegalArgumentException("Unsupported operating system");
        }

        System.out.println("Setting chrome driver path: "+chromeDriverPath);

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }
}
