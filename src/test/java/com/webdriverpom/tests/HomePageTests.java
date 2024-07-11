package com.webdriverpom.tests;

import com.webdriverpom.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePageTests {
    WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        Point position = new Point(-1920, 0);
        driver.manage().window().setPosition(position);
        driver.manage().window().maximize();
    }

    @Test
    public void testYogaBlockElementsVisible() {
        assert homePage.getShopNewYogaButton().isDisplayed();
    }

    @Test
    public void testYogaClicksThroughToYogaPage(){
        homePage.getShopNewYogaButton().click();
        System.out.println(driver.getCurrentUrl());
        assert driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/collections/yoga-new.html");
    }


}
