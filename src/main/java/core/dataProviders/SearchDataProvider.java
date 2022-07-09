package core.dataProviders;

import core.search.SearchWord;
import org.testng.annotations.DataProvider;
import utilityClasses.GenericUtilities;

import java.util.List;

public class SearchDataProvider {
    @DataProvider(name = "getSearchWords")
    public Object[][] getSearchWords(){
        List<SearchWord> searchList = GenericUtilities.readJsonFileToList("src/test/resources/data/searchData.json");
        return new Object[][] {{searchList}};
    }
}
