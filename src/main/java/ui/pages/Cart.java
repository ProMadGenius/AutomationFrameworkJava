package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.microsoft.com/es-mx/
public class Cart {
    @FindBy(id = "search")
    public WebElement SearchIcon;

    @FindBy(id = "uhf-shopping-cart")
    public WebElement CartBtn;

    // No page elements added



}