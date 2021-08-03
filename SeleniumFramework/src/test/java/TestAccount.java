import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAccount {

    @Test
    public void Test_Login_Successful(){
        String username = "juan.piedra@ucreativa.com";
        String password = "asdf";

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Go to Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        //Llenar Formulario
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();
        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        driver.close();
        driver.quit();

    }


}
