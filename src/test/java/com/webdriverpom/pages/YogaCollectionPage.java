package com.webdriverpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YogaCollectionPage {
    WebDriver driver;
    WebElement firstYogaClothingItem;

    public YogaCollectionPage(WebDriver driver) {
        this.driver = driver;
        this.firstYogaClothingItem = driver.findElement(By.className("product-item-info"));
    }

    public WebElement getFirstYogaClothingItem() {
        return firstYogaClothingItem;
    }




}
