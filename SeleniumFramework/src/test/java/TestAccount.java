import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAccount extends BaseClass{

    @Description("Validate test login was successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asdf";
        driver.manage().window().maximize();

        //Go to Login Page
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();

        //Llenar Formulario
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.ClickSubmitButton();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

    }

    @Description("Validate that the Login is working with non valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asdfasdf";
        String expectedMessage = "warning: no match for e-mail address and/or password.";
        driver.manage().window().maximize();

        loginPage.GoTo();
        loginPage.login(username,password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(),alertMessage.getText().toLowerCase().trim());

    }

    @Test
    public void Test_Create_New_Account(){

        //SetUp
        String firstName = "Juan";
        String lastName = "Piedra";
        String email = "juan@piedra.com";
        String telephone = "11111";
        String password = "asdf";
        String expectedMessage = "Register Account";

        //Register
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //Validation
        Assert.assertEquals(registerPage.GetConfirmationMessage(),expectedMessage);
    }
}
