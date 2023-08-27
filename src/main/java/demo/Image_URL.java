package demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Image_URL {
    WebDriver driver;

    public Image_URL() {
        System.out.println("Constructor:count hyperlinks");
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
        // Navigate to URL https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // get webelement list for "Recommended Movies" Using Locator "XPath"
        List<WebElement> imgs = driver
                .findElements(By.xpath("//h2[contains(text(),'Recommended Movies')]/../../../..//img"));

        // size ---> recommended movies
        System.out.println(imgs.size());
        System.out.println(" ");

        // iterate over list and store "id" attribute in string variable using
        // getAttribute("id") method and print it
        for (WebElement w : imgs) {
            String url = w.getAttribute("src");
            System.out.println(url);
            System.out.println(" ");
        }
        System.out.println("end Test case: testCase01");

    }

}