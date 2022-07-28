package com.amzon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondPage {
    public WebDriver driver;
    @FindBy(xpath="//h1[@id='title']")
    private WebElement title;

    @FindBy(id="add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(id="nav-cart-count")
    private WebElement cartCount;

    public SecondPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public String getTitleText(){
        return title.getText().trim();
    }

    public void clickOnAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public String getCartCount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cartCount));
        return cartCount.getText().trim();
    }
}
