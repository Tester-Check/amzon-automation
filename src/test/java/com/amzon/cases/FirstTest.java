package com.amzon.cases;

import com.amzon.pages.FirstPage;
import com.amzon.pages.SecondPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTest {

    private WebDriver driver;
    class NoBrowserException extends Exception{
        public NoBrowserException(String errorMessage){
            super(errorMessage);
        }
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUpCase(String browser) throws NoBrowserException {
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://amazon.com");
            driver.manage().window().maximize();
        }
        else{
            throw new NoBrowserException("Invalid browser. Please provide correct browser.");
        }
    }

    @AfterMethod
    public void tearDownCase(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        FirstPage firstPage = new FirstPage(driver);

        firstPage.enterInSearchField("2021 apple macbook pro");
        firstPage.clickOnSearchResult();
        firstPage.clickOnProductLink();

        SecondPage secondPage = new SecondPage(driver);

        Assert.assertEquals(secondPage.getTitleText(),
                "Macbook Pro 14 inch Screen Protector Privacy 2022-2021, " +
                        "FILMEXT Removable MacBook pro 14 Privacy Screen Filter for MacBook Pro 14 inch M1 " +
                        "2021 (A2442),Anti-Spy/Anti-Glare/Bubble Free/Easy On/Off");

        secondPage.clickOnAddToCart();
        Assert.assertEquals(secondPage.getCartCount(), "1");


    }
}
