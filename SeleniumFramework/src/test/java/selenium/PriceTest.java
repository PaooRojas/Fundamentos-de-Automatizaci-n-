package selenium;

import PageObjects.ProductPage;
import dataProviders.ProductProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Products;

public class PriceTest extends BaseClass {


    // Caso de prueba 3
    @Description("Product Prices")
    @Test(dataProvider = "getProductDataFromJson", dataProviderClass = ProductProvider.class)
    public void Test_ValidatePrice(Products testData) {
        ProductPage productPage = new ProductPage(driver);
        productPage().AddProductSearch(testData.getProduct());
        productPage().ClickOnProductSearched();

        headerPage().goToDollarCurrency();
        Assert.assertEquals(testData.getDollarPrice(), Double.parseDouble(productPage().getProductPrice().replace("$", "")));

        headerPage().goToPoundsCurrency();
        Assert.assertEquals(testData.getPoundsPrice(), Double.parseDouble(productPage().getProductPrice().replace("£", "")));

        headerPage().goToEuroCurrency();
        Assert.assertEquals(testData.getEuroPrice(), Double.parseDouble(productPage().getProductPrice().replace("€", "")));

    }
}




