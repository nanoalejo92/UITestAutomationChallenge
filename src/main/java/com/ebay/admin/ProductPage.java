package com.ebay.admin;

import com.ebay.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ProductPage extends Base {


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Objects
    By txtSearchBar = By.xpath("//input[@id='gh-ac']");
    By chkBrands = By.cssSelector("input[aria-label='adidas']");
    By btnSearch = By.xpath("//input[@id='gh-btn']");
    By txtResults = By.cssSelector("h1.srp-controls__count-heading > span.BOLD");

    public void searchAdidas(String brand){
        type(txtSearchBar, brand);
        click(btnSearch);
        implicitlyWait();
    }

    public void filterAdidas(){
        click(chkBrands);
    }

    public void searchResults(){
        System.out.println(getText(txtResults));
        int result = Integer.parseInt(getText(txtResults));
        assertEquals(result,2000);
    }

    public void logoutEbay() {
        implicitlyWait();
        closeBrowser();
    }

}
