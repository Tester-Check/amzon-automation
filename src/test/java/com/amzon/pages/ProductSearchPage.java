package com.amzon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSearchPage {
    public WebDriver driver;
    @FindBy(id="twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath="//span[text()=' 14 inch'][@class='s-heavy']")
    private WebElement proMax13SearchResult;

    @FindBy(xpath="(//h2)/a/span[contains(text(), 'Macbook Pro 14 inch Screen Protector')]")
    private WebElement linkProMax13;


    public ProductSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterInSearchField(String product){
        searchField.sendKeys(product);
    }

    public void clickOnSearchResult(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(proMax13SearchResult));
        proMax13SearchResult.click();
    }

    public void clickOnProductLink(){
        linkProMax13.click();
    }


}
