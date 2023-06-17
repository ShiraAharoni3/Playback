package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.lang.Thread;



public class ChartScraper extends Thread
{
    public static List<ChartEntry> getChartData(int year, String chartType)
    {
        System.setProperty("webdriver.openqa.driver", "src/main/java/org/example/chromDriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU acceleration

        // Initialize ChromeDriver with the configured options
        WebDriver driver = new ChromeDriver(options);

        // Initialize ChromeDriver

        String baseUrl = "https://playback.fm/charts/";
        String url = baseUrl + chartType + "/" + Integer.toString(year) ;
//         String url = baseUrl + "rock" + "/" + Integer.toString(year) ;

            // Set the path to your ChromeDriver executable

            // Navigate to the URL
            driver.get(url);

            // Find all table rows
            List<WebElement> rows = driver.findElements(By.tagName("tr"));

            // Initialize chart data list
            List<ChartEntry> chartData = new ArrayList<>();

            // Iterate over rows and extract data
            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));
                if (!columns.isEmpty()) {
                    String rank = columns.get(0).getText();
                    String title = columns.get(2).getText();
                    String artist = columns.get(1).getText();
                    chartData.add(new ChartEntry(rank, title, artist));
                }
            }
            try {
                Thread.sleep(10000);
            }
            catch( Exception e ) {
            }

            // Close the WebDriver
            driver.quit();

            return chartData;
        }
}


