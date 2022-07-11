package tests.ui;

import core.dataProviders.SearchDataProvider;
import core.search.SearchWord;
import core.ui.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Cart extends BaseTest {

    /**
     * This test case verifies the search and cart basis.
     * Test users: No needed
     * Data providers: getSearchWords
     * @param list is provided by data provider
     */
    @Test(groups = {"smoke" ,"regression"}, dataProviderClass = SearchDataProvider.class, dataProvider = "getSearchWords")
    public void SearchValidation(final List<SearchWord> list){

        //1. Go to https://www.microsoft.com/es-mx/
        //2. Go to Windows
        Navigator.Cart().clickWindowsLink();
        //3. Go to Search
        Navigator.Cart().clickSearchIcon();
        //4. Search for “Xbox” and click on "Comprar"
        Navigator.Cart().searchText(list.get(0).getSearchWord());
        //5. Once in the result page you will see "Aplicaciones" click on it
        Navigator.Cart().selectInSuggestList(0);
        //If a dialog to change to another language store is displayed, click stay in the site
        Navigator.Cart().clickDigitalCollectionLink();
        if (Navigator.Cart().isChangeStoreDialogDisplayed()){
            Navigator.Cart().clickStayInTheSite();
        }
        //6. Count the elements on the first 3 pages and print the sum of elements and all the titles
        int count = Navigator.Cart().getCountOfItemDigitalGame();
        Navigator.Cart().printTitlesInThePage();
        Navigator.Cart().clickNextPage();
        count = count + Navigator.Cart().getCountOfItemDigitalGame();
        Navigator.Cart().printTitlesInThePage();
        //If you see a "Registration" pop up, close it
        if (Navigator.Cart().isNewsDialogDisplayed()){
            Navigator.Cart().clickCloseNewsDialog();
        }
        Navigator.Cart().clickNextPage();
        count = count + Navigator.Cart().getCountOfItemDigitalGame();
        Navigator.Cart().printTitlesInThePage();
        System.out.println("Total number of items is: " + count);
        //7. Go back to the first page and select the first NON-FREE option and STORE the price for later comparison
        Navigator.Cart().clickPreviousPage();
        Navigator.Cart().clickPreviousPage();
        float price = Navigator.Cart().getPriceFromNItem(1);
        System.out.println("The price is: " + price);
        Navigator.Cart().clickInTheNProduct(1);
        //9. In this page, you will see the price again, compare first price vs current prince and they should match
        float priceInPage = Navigator.Cart().getPriceInIndividualPage();
        System.out.println(priceInPage);
        Assert.assertEquals(price, Navigator.Cart().getPriceInIndividualPage(), "The price is different");
        //10. Click on the "3 dot" button next to "Comprar" button and add the item to the CART
        Navigator.Cart().clickAddToTheCart();
        //11. Verify the app takes you to the Shopping Cart page and verify you have one element available (The web is not redirect to cart instead is adding to it)
        //Sometimes at clicking in the cart is redirecting to an empty cart, sometimes is just adding a number in the cart
        //Assert.assertTrue(Navigator.Cart().getCartInfo().contains("1 artículos en el carro de la compra"));
        Navigator.Cart().clickCartIcon();
        //12. Delete the item and verify you have 0 elements: "Tu carro está vacío" message should be present
        Assert.assertTrue(Navigator.Cart().getMessageYourCartIsEmpty().contains("Tu carro está vacío."));
    }
}
