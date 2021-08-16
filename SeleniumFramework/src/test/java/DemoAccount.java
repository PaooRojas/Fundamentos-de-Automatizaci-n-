import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class DemoAccount {

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Ignore
    @Test
    public void test_capabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1700,800");
        options.addArguments("--headless");
        options.setHeadless(true);
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed());

        //driver.manage().window().maximize();

        driver.close();
        driver.quit();
    }

    @Test
    public void test_waits() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")).click();

        boolean result = false;

        //manejo de exceptions
        try {
            result = wait.until(
                    ExpectedConditions.textToBe(
                            By.className("progress-label"), "Complete!"));
        } catch (WebDriverException exception) {
            System.out.println("No funcionó");
        }

        driver.close();
        driver.quit();

    }

}
