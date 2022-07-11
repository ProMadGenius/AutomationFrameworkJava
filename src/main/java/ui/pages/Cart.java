package ui.pages;

import core.ui.BasePage;
import core.ui.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

// page_url = https://www.microsoft.com/es-mx/
public class Cart extends BasePage {
    @FindBy(id = "search")
    public WebElement searchIcon;

    @FindBy(id = "uhf-shopping-cart")
    public WebElement CartBtn;

    @FindBy(id = "shellmenu_2")
    public WebElement windowsLink;

    @FindBy(id = "cli_shellHeaderSearchInput")
    public WebElement searchInput;

    @FindBy(id = "universal-header-search-auto-suggest-ul")
    public WebElement suggestionListSearch;

    @FindBy(id = "onestore-quicklinksmodule-po1wqqs-quicklink2")
    public WebElement digitalGamesLink;

    @FindBy(id = "R1MarketRedirect-1")
    public WebElement changeStoreLanguageDialog;

    @FindBy(id = "R1MarketRedirect-submit")
    public WebElement stayIntheSiteDialogBtn;

    @FindBy(css = "a[aria-label='ver colección xbox juegos digitales']")
    public WebElement digitalGamesCollectionLink;

    @FindBy(css = "div[class='c-group f-wrap-items context-list-page']")
    public WebElement groupItemGames;

    public int getCountOfItemDigitalGame(){
        return groupItemGames.findElements(By.cssSelector("div.m-channel-placement-item img")).size();
    }

    public void printTitlesInThePage(){
        groupItemGames.findElements(By.cssSelector("div.m-channel-placement-item img")).forEach(webElement -> System.out.println(webElement.getAttribute("title")));
    }

    public void clickWindowsLink(){
        waitForElementToBeClickable(windowsLink);
        windowsLink.click();
        waitForElementToBeClickable(searchIcon);
    }

    public void clickStayInTheSite(){
        stayIntheSiteDialogBtn.click();
    }

    public void clickDigitalCollectionLink(){
        digitalGamesCollectionLink.click();
    }

    public boolean isChangeStoreDialogDisplayed(){
        waitForLocatedElementToBeVisible(changeStoreLanguageDialog);
        return changeStoreLanguageDialog.isDisplayed();
    }

    public void clickDigitalGamesLink(){
        waitForElementToBeClickable(digitalGamesLink);
        digitalGamesLink.click();
    }

    public void clickSearchIcon(){
        searchIcon.click();
        waitForElementToBeClickable(searchInput);
    }

    public void searchText(String text){
        searchInput.clear();
        ElementActions.setText(searchInput, text);
    }

    public void selectInSuggestList(int pos){
        waitForElementToBeAvailable(suggestionListSearch);
        List<WebElement> list = suggestionListSearch.findElements(By.className("c-menu-item"));
        list.get(pos).click();
    }

    // No page elements added



}