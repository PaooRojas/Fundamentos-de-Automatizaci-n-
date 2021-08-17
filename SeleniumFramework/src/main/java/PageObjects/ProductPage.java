package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    //Elementos
    public String ProductTitleSelector = "//h1[text()='<name>']";
    public By ProductQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By AlertSuccess = By.cssSelector(".alert-success");
    public By ClickOnProductSearchedLocator = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img");
    public By AddProductSearchLocator = By.name("search");
    public By ClickOnShoppingCart = By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span");
    public By ProductPriceLocator = By.xpath("(//h2)[2]");


    public ProductPage(WebDriver _driver){super(_driver);}

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>", name))).isDisplayed();
    }
    public void SetQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }
    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }
    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }
    public void  ClickOnProductSearched(){driver.findElement(ClickOnProductSearchedLocator).click(); }
    public void AddProductSearch (String _product){
        driver.findElement(AddProductSearchLocator).sendKeys(_product, Keys.ENTER);
    }
    public void ShoppingCart (){
        driver.findElement(ClickOnShoppingCart).click();
    }
    public String getProductPrice(){return driver.findElement(ProductPriceLocator).getText();}
}
