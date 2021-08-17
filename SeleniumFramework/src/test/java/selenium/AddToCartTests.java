package selenium;

import PageObjects.HeaderPage;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.ShoppingCartPage;
import io.qameta.allure.Description;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;




public class AddToCartTests extends BaseClass {

    int quantity = 5;

    HeaderPage headerPage = new HeaderPage(driver);
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    /*String name = homePage().selectFirstProductAndGetName();
    Assert.assertTrue(productPage().isTitleDisplayed(name));
    productPage().SetQuantity(quantity);
    productPage().clickAddButton();
    Assert.assertTrue(productPage().isAlertSuccessDisplayed());
    headerPage().clickOnCartButton();
    try {
        Thread.sleep(2);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    //Assert.assertTrue(shoppingCartPage().isProductRowDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductRowQuantity(),quantity, "Quantity is not matching");
    //Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL),"image is not the one expected");
} */

    //Caso de Prueba 2
    @Description("validate add to cart")
    @Test
    public void Test_Add_To_Cart(@Optional("macbook") String searchCriteria) {

        String productAddedMessage = "Success: You have added MacBook to your shopping cart!";
        String productNotAvailableMessage = "Products marked with *** are not available in the desired quantity or not in stock!";


        productPage().AddProductSearch(searchCriteria);
        productPage().ClickOnProductSearched();
        productPage().SetQuantity(9);
        productPage().clickAddButton();
        //Assert.assertTrue(shoppingCartPage().getProductAddedMessage(), "Success: You have added MacBook to your shopping cart!"+ "*");
        //Assert.assertEquals(shoppingCartPage().getProductAddedMessage(), productAddedMessage);




        headerPage().clickOnCartButton();
        shoppingCartPage().checkOutButton();
       // Assert.assertTrue(shoppingCartPage().getProductNotAvailableMessage(), "Products marked with *** are not available in the desired quantity or not in stock!");
        //Assert.assertEquals(shoppingCartPage.getProductNotAvailableMessage(), productNotAvailableMessage);


    }
}







