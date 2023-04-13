package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GroupUkrTest {

    @Test
    public void youtubeSearchTest(){
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--headless","--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(optionsChrome);
        driver.get("https://www.youtube.com/");

        String title = driver.getTitle();
        Assert.assertEquals("YouTube", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search']"));
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));

        searchInput.sendKeys("Что такое Selenium?");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        searchButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        WebElement link = driver.findElement(By.xpath("//a[@title='Что такое Selenium?']"));
        String value = link.getText();

        Assert.assertEquals(value, "Что такое Selenium?");

        driver.quit();

    }
    @Test
    public void VNZooleaderTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless","--window-size= 1920,1080");

        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://zooleader.com.ua/");

        WebElement srchField = driver.findElement(By.xpath("//header[@class = 'header header--fixed']//input[@id='search']"));
        WebElement srchBtn = driver.findElement(By.xpath("//header[@class = 'header header--fixed']//button[@class='block-search__btn']"));

        wait.until(ExpectedConditions.elementToBeClickable(srchField));

        srchField.sendKeys("36494");
        srchBtn.click();

        WebElement resultName = driver.findElement(By.xpath("//section[@class = 'product__hero']//h1[@class='product__title']"));

        Assert.assertTrue(resultName.getText().contains("Davis «Pink Grapefruit»"));

        driver.quit();

    }

}
