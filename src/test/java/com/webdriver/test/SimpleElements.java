package com.webdriver.test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SimpleElements {

    WebDriver driver = new ChromeDriver();


    @Test
    public void elementsAreDisplayed() {
        assert driver.findElement(By.id("idExample")).isDisplayed();
        assert driver.findElement(By.className("buttonClass")).isDisplayed();
    }

    @Test
    public void clickIDButton() {
    WebElement greenIdButton = driver.findElement(By.id("idExample"));
    greenIdButton.click();
    assert driver.findElement(By.className("entry-title")).getText().equals("Button success");
    }

    @Test
    public void clickClassButton() {
        driver.findElement(By.className("buttonClass")).click();
        System.out.println(driver.findElement(By.className("entry-title")).getText());
        assert driver.findElement(By.className("entry-title")).getText().equals("Button success");
    }

    @BeforeEach
    public void setUp(){
       driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterEach
    public void tearDown(){
      driver.quit();
    }

}
