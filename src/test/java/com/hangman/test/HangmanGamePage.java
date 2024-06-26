package com.hangman.test;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class HangmanGamePage
{
    public SelenideElement letterButtonX = $(byAttribute("data-testid", "letter-button-x"));

    public SelenideElement letterBoard = $(byAttribute("data-testid", "letter-board"));

    public SelenideElement missCount = $(byAttribute("data-testid", "miss-count"));

    public SelenideElement winMessage = $(byAttribute("data-testid", "win-message"));

    public SelenideElement lossMessage = $(byAttribute("data-testid", "loss-message"));
}
