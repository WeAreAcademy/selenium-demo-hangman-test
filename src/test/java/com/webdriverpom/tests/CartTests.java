package com.webdriverpom.tests;

import com.webdriverpom.actions.ItemPageActions;
import com.webdriverpom.pages.CartPopup;
import com.webdriverpom.pages.HomePage;
import com.webdriverpom.pages.ItemDetailPage;
import com.webdriverpom.pages.YogaCollectionPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class CartTests {
    WebDriver driver;
    HomePage homePage;
    YogaCollectionPage yogaCollectionPage;
    CartPopup cartPopup;
    ItemDetailPage itemDetailPage;
    ItemPageActions cartActions;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        Point position = new Point(-1920, 0);
        driver.manage().window().setPosition(position);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addYogaItemItemToCartByFirstSizeAndColour(){
        homePage.getShopNewYogaButton().click();
        System.out.println(driver.getCurrentUrl());
        yogaCollectionPage = new YogaCollectionPage(driver);
        yogaCollectionPage.getFirstYogaClothingItem().click();
        System.out.println(driver.getCurrentUrl());
        cartActions = new ItemPageActions(driver);
        cartActions.AddItemToCartByFirstSizeAndColour();
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);
        String itemPrice = itemDetailPage.getItemPrice();
        System.out.println("Item Price = " + itemPrice);
        makeCartPopupVisible();
        cartPopup = new CartPopup(driver);
        System.out.println("Cart Subtotal = " + cartPopup.getCartSubtotal());
        assert cartPopup.getCartSubtotal().equals(itemPrice);
    }

    @Test
    public void addYogaItemToCartByLastSizeAndColour(){
        homePage.getShopNewYogaButton().click();
        System.out.println(driver.getCurrentUrl());
        yogaCollectionPage = new YogaCollectionPage(driver);
        yogaCollectionPage.getFirstYogaClothingItem().click();
        System.out.println(driver.getCurrentUrl());
        cartActions = new ItemPageActions(driver);
        cartActions.AddItemToCartByLastSizeAndColour();
    }

    @Test
    public void addFourYogaItemsToCartByFirstSizeAndColour(){
        homePage.getShopNewYogaButton().click();
        System.out.println(driver.getCurrentUrl());
        yogaCollectionPage = new YogaCollectionPage(driver);
        yogaCollectionPage.getFirstYogaClothingItem().click();
        System.out.println(driver.getCurrentUrl());
        cartActions = new ItemPageActions(driver);
        cartActions.AddSpecificNumberOfItemsToCartByFirstSizeAndColour("4");
    }
    @Test
    public void checkCartPopupIsVisible(){
        makeCartPopupVisible();
        cartPopup = new CartPopup(driver);
        assert cartPopup.getCartPopupModal().isDisplayed();
    }


    public void makeCartPopupVisible(){
        driver.findElement(By.cssSelector(".action.showcart")).click();
    }

}
