package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By yourStoreButtonLocator = By.linkText("Your Store");
    private By CurrencyButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/button");
    private By DollarButtonLocator = By.name("USD");
    private By PoundsButtonLocator = By.name("GBP");
    private By EuroButtonLocator = By.name("EUR");


    public HeaderPage(WebDriver _driver){
        super(_driver);
    }
    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();

    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }
    public void clickOnCartButton(){driver.findElement(shoppingCartLocator).click();}
    public void clickOnYourStoreButton() {driver.findElement(yourStoreButtonLocator).click();}
    public void clickOnCurrencyButton() {driver.findElement(CurrencyButtonLocator).click();}
    public void clickOnDollarButton() {driver.findElement(DollarButtonLocator).click();}
    public void clickOnPoundsButton() {driver.findElement(PoundsButtonLocator).click();}
    public void clickOnEuroButton() {driver.findElement(EuroButtonLocator).click();}

    public void goToDollarCurrency(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnDollarButton();
    }

    public void goToPoundsCurrency(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnPoundsButton();
    }
    public void goToEuroCurrency(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnEuroButton();
    }

}
