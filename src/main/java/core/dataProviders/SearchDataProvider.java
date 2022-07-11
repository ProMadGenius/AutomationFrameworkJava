package core.dataProviders;

import core.search.SearchWord;
import org.testng.annotations.DataProvider;
import utilityClasses.GenericUtilities;

import java.util.ArrayList;
import java.util.List;

public class SearchDataProvider {
    @DataProvider(name = "getSearchWords")
    public Object[][] getSearchWords(){
        List<SearchWord> searchList = new ArrayList<>();
        //TODO: GenericUtilities.readJsonFileToList("src/test/resources/data/searchData.json");
        SearchWord word = new SearchWord();
        word.setSearchWord("xbox");
        searchList.add(word);
        return new Object[][] {{searchList}};
    }
}
