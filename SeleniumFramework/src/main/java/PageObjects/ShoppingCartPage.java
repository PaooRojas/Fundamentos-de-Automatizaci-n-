package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {

    public String ProductNameLocator = "//div[@id='content']//a[text()='<name>']";
    public By ProductQuantityLocator = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input\"");

    private String productRowLocator = "//div[@id='content']//tr[contains(.,'<name>')]";
    private WebElement productRow;
    private By inputRowSelector = By.cssSelector("input");
    private By imageSelector = By.cssSelector("img");
    private By shoppingCartRows = By.xpath("//div[@id='content']//div[contains(@class, 'table-responsive')]//tr");
    private By checkOutButton = By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a");
    private static By productAddedMessage = By.xpath("//*[@id=\"product-product\"]/div[1]");
    private static By productNotAvailableMessage = By.xpath("/html/body/div[2]/div[1]");


    public ShoppingCartPage(WebDriver _driver) {
        super(_driver);
    }

    public boolean isProductNameDisplayed(String name) {
        return driver.findElement(By.xpath(ProductNameLocator.replace("<name>", name))).isDisplayed();
    }

    public int getProductQuantity() {
        return Integer.parseInt(driver.findElement(ProductQuantityLocator).getAttribute("value"));
    }

    public boolean isProductRowDisplayed(String name) {
        this.productRow = driver.findElement(By.xpath(productRowLocator.replace("<name>", name)));
        return this.productRow.isDisplayed();
    }

    public int getProductRowQuantity() {
        String Amount = productRow.findElement(inputRowSelector).getAttribute("value");
        return Integer.parseInt(Amount);
    }

    public String getProductImageURL() {
        String imageURL = productRow.findElement(imageSelector).getAttribute("src");
        return imageURL;
    }

    public void checkOutButton() {

    }

    public boolean getProductAddedMessage() {

        if (driver.findElement(productAddedMessage).getText().equals("Success: You have added MacBook to your shopping cart!"))
            return true;
        else
            return false;

    }

    public boolean getProductNotAvailableMessage() {

        if (driver.findElement(productNotAvailableMessage).getText().equals("Products marked with *** are not available in the desired quantity or not in stock!"))
            return true;
        else
            return false;

    }

}


