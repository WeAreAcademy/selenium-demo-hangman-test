package com.hangman.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HangmanGamePageTest {
    //I'm not really using this but it was in the sample code.
    //seems to be a way to extract out element selectors nicely.

    //HangmanGamePage gamePage = new HangmanGamePage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        String pageUnderTest = "https://hangman-game-solution.netlify.app/?testWord=mississippi";


        open(pageUnderTest);
    }

    @Test
    public void playGameToVictory() {
        //play a game of hangman from start to finish, winning.


        //number of misses should start at zero
        //game over shouldn't be present
        //letterBoard should display _ _ _ _ _ _ _ _ _ _ _  etc.
        //click x
        //number of misses should increment
        // letterBoard shouldn't change
        //click i
        //letterBoard should show the 4 is in mississippi, and underscores for the rest
        // number of guesses should not have incremented
        //i should now be disabled
        //click m
        //click s
        // game should not be over
        //click p
        // win message should be present
        // loss message should not be present


        // Verify initial state
        $("[data-testid='miss-count']").shouldHave(text("0"));
        $("[data-testid='loss-message']").shouldNotBe(visible);
        $("[data-testid='win-message']").shouldNotBe(visible);
        $("[data-testid='letter-board']").shouldHave(matchText("_ _ _ _ _ _ _ _ _ _ _"));

        // Click 'X' - this will be a miss
        $("[data-testid='letter-button-x']").click();
        // alternatively mainPage.keyboardButtonX.click();

        // Verify misses increment
        $("[data-testid='miss-count']").shouldHave(text("1"));
        //$("[data-testid='letter-board']").shouldHave(text(equalIgnoringCase($("[data-testid='letter-board']").text()))); // Avoid redundant check

        // Click 'I'
        $("[data-testid='letter-button-i']").click();

        // Verify letter board updates and 'I' is disabled
        $("[data-testid='letter-board']").shouldHave(text("_ i _ _ i _ _ i"));
        $("[data-testid='letter-button-i']").shouldBe(disabled);

        // Click 'M' and 'S'
        $("[data-testid='letter-button-m']").click();
        $("[data-testid='letter-button-s']").click();

        // Verify game is not over
        $("[data-testid='win-message']").shouldNotBe(visible);

        // Click 'P'
        $("[data-testid='letter-button-p']").click();

        // Verify win message and no loss message
        $("[data-testid='win-message']").shouldBe(visible);
        $("[data-testid='loss-message']").shouldNotBe(visible);
        $("[data-testid='letter-board']").shouldHave(text("m i s s i s s i p p i"));
    }
}