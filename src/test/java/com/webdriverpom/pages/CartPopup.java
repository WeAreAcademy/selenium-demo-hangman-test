package com.webdriverpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPopup {
    WebDriver driver;
    WebElement cartPopupModal;
    String cartSubtotal;

    public CartPopup(WebDriver driver) {
        this.driver = driver;
        this.cartPopupModal = driver.findElement(By.cssSelector(".block.block-minicart.ui-dialog-content.ui-widget-content"));
        this.cartSubtotal = driver.findElement(By.className("price")).getText();

    }

    public WebElement getCartPopupModal() {
        return cartPopupModal;
    }

    public String getCartSubtotal() {
        return cartSubtotal;
    }
}
