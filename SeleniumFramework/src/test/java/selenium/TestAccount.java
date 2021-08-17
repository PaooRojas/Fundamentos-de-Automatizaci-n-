package selenium;

import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.Utils;
import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserAccount;


public class TestAccount extends BaseClass {
    public static final String ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE = "warning: no match for e-mail address and/or password.";

    //Elements
    public By logOutButtonLocator = By.linkText("Logout");
    public By alertMessageLocator = By.xpath("//div[contains(@class, 'alert-danger')]");


    @Description("Validate test login was successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        String username = "juan.piedra@ucreativa.com";
        String password = "asdf";
        driver.manage().window().maximize();

        //Go to Login Page
        headerPage().clickOnMyAccount();
        headerPage().clickOnLoginButton();

        //Llenar Formulario
        loginPage().EnterEmail(username);
        loginPage().EnterPassword(password);
        loginPage().ClickSubmitButton();

        WebElement logOutButtonLocator = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButtonLocator.isDisplayed());

    }

    @Description("Validate that the Login is working with non valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful() {
        String username = "juan.piedra@ucreativa.com";
        String password = "asdfasdf";
        String expectedMessage = "warning: no match for e-mail address and/or password.";
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.GoTo();
        loginPage.login(username,password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(),alertMessage.getText().toLowerCase().trim());

    }

    @Test(dataProvider = "getUsersData", dataProviderClass = UsersProvider.class)
    public void Test_Login_With_Data(UserAccount testUser){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.GoTo();
        loginPage.login(testUser.getEmail(), testUser.getPassword());
        if (testUser.isValidAccount())
            Assert.assertTrue(driver.findElement(logOutButtonLocator).isDisplayed());
        else
            Assert.assertEquals(ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE.toLowerCase(),driver.findElement(alertMessageLocator).getText().toLowerCase().trim());

    }

    //Caso de Prueba 1
    @Test
    public void Test_Create_New_Account(){

        //Register
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.GoTo();
        String[] userInfo = Utils.generateNewUserInfo();
        registerPage.FillForm(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]);

        //Validation
        Assert.assertTrue(registerPage.GetConfirmationMessage(),"Your Account Has Been Created!");
    }

}
