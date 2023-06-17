package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static org.example.ChartScraper.getChartData;


public class YearScraper
{
    public static List<String> getYears()
    {
        System.setProperty("webdriver.openqa.driver", "src/main/java/org/example/chromDriver.exe");
        //System.setProperty("webdriver.chrome.driver", "<COMPLETE_PATH_TO_YOUR_DRIVER>");

        // defining the options to run Chrome in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");


        // setting the system property for the Chrome Driver


        // initializing a Selenium WebDriver ChromeDriver instance
        // to run Chrome in headless mode
        WebDriver driver = new ChromeDriver(options);


        // connecting to the target web page
        driver.get("https://playback.fm/charts/top-100-songs");

        // initializing the list of Java object to store
        // the scraped data
        //List<Integer> pokemonProducts = new ArrayList<>();
        List<String> years = new ArrayList<>();
        List<String> modifiedList = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector(".allYears a"));
        //List<WebElement> artists = driver.findElements(By.xpath("//span[contains(@itemprop, 'byArtist')]"));


        // Print the years
        for (WebElement element : elements) {
            String text = element.getText();
            years.add(text);
        }
        for (String item : years)
        {
            String ModifiedItem = item.replace("Pop Chart" ,"");
            modifiedList.add(ModifiedItem);
        }
        //System.out.println(years.size());
       /* for (String item : modifiedList) {
            System.out.println(item);
        }*/

            // Close the WebDriver
            driver.quit();

            return modifiedList;
        }
}

