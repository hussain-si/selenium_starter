package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImdbRatings {

    ChromeDriver driver;

    public ImdbRatings() {
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

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.imdb.com/chart/top");
        Thread.sleep(3000);
        // the highest rated movie on IMDb
        WebElement topRated = driver.findElement(By.xpath("(//div[@class='ipc-metadata-list-summary-item__tc'])[1]"));
        System.out.println(topRated.getText());
        // movies included in the table
        List<WebElement> movies = driver.findElements(By.className("sc-14dd939d-0 fBusXE cli-children"));
        System.out.println(movies.size());

    }

}