package com.hangman.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

//A place to declare some elements for convenience.  Not actually needed for the test unless you want to use it.
public class HangmanGamePage
{
    public SelenideElement letterBoard = $(byAttribute("data-testid", "letter-board"));

    public SelenideElement missCount = $(byAttribute("data-testid", "miss-count"));

    public SelenideElement winMessage = $(byAttribute("data-testid", "win-message"));

    public SelenideElement lossMessage = $(byAttribute("data-testid", "loss-message"));

    public SelenideElement letterButtonM = $(byAttribute("data-testid", "letter-button-m"));
    public SelenideElement letterButtonI = $(byAttribute("data-testid", "letter-button-i"));
    public SelenideElement letterButtonP = $(byAttribute("data-testid", "letter-button-p"));
    public SelenideElement letterButtonS = $(byAttribute("data-testid", "letter-button-s"));
    public SelenideElement letterButtonX = $(byAttribute("data-testid", "letter-button-x"));
}
