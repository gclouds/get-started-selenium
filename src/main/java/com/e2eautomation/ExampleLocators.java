package com.e2eautomation;

public class ExampleLocators {

    public static void main(String[] args) {

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

        // Locating the search input field using Name
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium WebDriver");

        // Locating the Google Search button using Name
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        // Locating the "Images" link using LinkText
        WebElement imagesLink = driver.findElement(By.linkText("Images"));
        imagesLink.click();

        // Locating the "Google offered in:" dropdown using PartialLinkText
        WebElement languageDropdown = driver.findElement(By.partialLinkText("Google offered in:"));
        languageDropdown.click();

        // Locating the "Privacy" link using TagName
        WebElement privacyLink = driver.findElement(By.tagName("a"));
        System.out.println("Privacy Link Text: " + privacyLink.getText());

        // Locating the search input field using ClassName
        WebElement searchInputByClass = driver.findElement(By.className("gLFyf"));
        searchInputByClass.clear();
        searchInputByClass.sendKeys("Java Programming");

        // Locating the first search result using CSS Selector
        WebElement firstSearchResult = driver.findElement(By.cssSelector("div.rc h3"));
        System.out.println("First Search Result Title: " + firstSearchResult.getText());

        // Locating the "I'm Feeling Lucky" button using XPath
        WebElement luckyButton = driver.findElement(By.xpath("//input[@name='btnI']"));
        luckyButton.click();

        // Wait for a while to observe the results
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the WebDriver
        driver.quit();
    }

}
