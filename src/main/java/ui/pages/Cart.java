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

    @FindBy(css = "a[aria-label='página siguiente']")
    public WebElement nextPage;

    @FindBy(css = "a[aria-label='página anterior']")
    public WebElement previousPage;

    @FindBy(xpath = "//button[contains(@data-m, 'BuyButton')]")
    public WebElement buyButton;

    @FindBy(css = ".c-channel-placement-price span[itemprop='price']")
    public WebElement priceItem;

    @FindBy(xpath = "//div[@class='ProductActionsPanel-module__desktopProductActionsPanel___1MnpC']//span[contains(@class, 'Price-module__boldText___34T2w')]")
    public WebElement priceInIndividualPage;

    @FindBy(css = ".store-cart-app p.c-paragraph-2")
    public WebElement messageInCart;

    public String getMessageYourCartIsEmpty(){
        return messageInCart.getText();
    }

    public float getPriceFromNItem(int pos){
        return getPriceFromString(groupItemGames.findElements(By.cssSelector("span[itemprop='price']")).get(pos).getAttribute("content"));
    }

    public float getPriceInIndividualPage(){
        return getPriceFromString(priceInIndividualPage.getText());
    }

    public void clickBuyButton(){
        buyButton.click();
    }

    public void clickNextPage(){
        nextPage.click();
    }

    public void clickPreviousPage(){
        previousPage.click();
    }

    public int getCountOfItemDigitalGame(){
        return groupItemGames.findElements(By.cssSelector("div.m-channel-placement-item img")).size();
    }

    public void clickInTheNProduct(int n){
        groupItemGames.findElements(By.cssSelector("div.m-channel-placement-item img")).get(n).click();
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

    public float getPriceFromString(String input){
        return Float.parseFloat(input.replaceAll(".*?(-?[\\d.]+).*", "$1"));
    }



}