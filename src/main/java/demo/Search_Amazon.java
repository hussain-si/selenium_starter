package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_Amazon {
    WebDriver driver;

    public Search_Amazon() {
        System.out.println("Constructor: Search amazon");
        // WebDriverManager.firefoxdriver().timeout(30).setup();
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Amazon");
        search.submit();
        WebElement amazon = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']"));
        System.out.println(amazon.isDisplayed());
        System.out.println(amazon.getText());

    }

}