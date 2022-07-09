package tests.ui;

import core.dataProviders.SearchDataProvider;
import core.search.SearchWord;
import core.ui.BaseTest;
import org.testng.annotations.Test;

public class Cart extends BaseTest {

    /**
     * This test case verifies the search and cart basis.
     * Test users: No needed
     * Data providers: getBatchSignData
     * @param list is provided by data provider
     */
    @Test(groups = {"smoke" ,"regression"}, dataProviderClass = SearchDataProvider.class, dataProvider = "getSearchWords")
    public void SearchValidation(final SearchWord list){

        //1. Go to https://www.microsoft.com/es-mx/
        Navigator.Cart().SearchIcon.click();
        //2. Go to Windows
        //3. Go to Search
        //4. Search for “Xbox” and click on "Comprar"
        //5. Once in the result page you will see "Aplicaciones" click on it
        //6. Count the elements on the first 3 pages and print the sum of elements and all the titles
        //7. Go back to the first page and select the first NON-FREE option and STORE the price for later comparison
        //8. If you see a "Registration" pop up, close it
        //9. In this page, you will see the price again, compare first price vs current prince and they should match
        //10. Click on the "3 dot" button next to "Comprar" button and add the item to the CART
        //11. Verify the app takes you to the Shopping Cart page and verify you have one element available
        //12. Delete the item and verify you have 0 elements: "Tu carro está vacío" message should be present


    }
}
