package com.ebay.mainpage.qa;

import com.ebay.admin.ProductPage;
import com.ebay.base.Base;
import com.ebay.base.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001 {

    WebDriver driver;
    Base base;
    ProductPage product;
    String brand;

    @BeforeTest
    public void beforeTest() {

        // Set up driver
        base = new Base(driver);
        driver = base.chromeDriver();
        product = new ProductPage(driver);

        // Test Data
        this.brand = "shoes";

    }

    @Test
    public void TC001_SEARCHADIDAS() {

        base.launchBrowser(GlobalVariables.QA_URL);
        product.searchAdidas(brand);
        product.filterAdidas();
        product.searchResults();
        product.logoutEbay();

    }

    @AfterTest
    public void afterTest() {

    }

}

