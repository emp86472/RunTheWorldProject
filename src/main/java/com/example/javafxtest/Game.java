package com.example.javafxtest;

import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Other things to work on:
 * Key event cards that modify. Maybe we can have 2 separate
 * arrays, a key event card array and a generic event card array
 *
 * MAYBE we could have sound fx, doesnt look too hard..
 *
 */
public class Game {
    private int env, eco, soc, po;
    //po for public opinion
    private static int decisionCount;
    private Card[] deck;
    private Label prompt = new Label();
    private Card card;
    Random r = new Random();

    //lets say the cap is 100
    public Game() {
        prompt.setText("Click yes to play!");
        this.env = 50;
        this.eco = 50;
        this.soc = 50;
        this.po = 50;
    } //Game constructor

    //something to work on!
    //currently PO does not affect the game
    //main game loop
    public void run(boolean decision) {
        int env = this.card.getEnv();
        int eco = this.card.getEco();
        int soc = this.card.getSoc();
        if (decision) {
            this.env += env;
            this.eco += eco;
            this.soc += soc;
            this.po += 10;
        } else {
            this.po -= 10;
        } //if
        this.card = this.deck[r.nextInt(deck.length)];
        if (this.env >= 0 && this.eco >= 0 && this.soc >= 0) {
            String prompt = card.getPrompt();
            this.prompt.setText(prompt);
            decisionCount++;
            //we need different messages for each lose condition
            //whichever happens first
        } else {
            this.prompt.setText("Game Over!");
        } //if
    } //run

    //getters and setters
    public int getEnv() {
        return this.env;
    } //getEnv

    public int getEco() {
        return this.eco;
    } //getEco

    public int getSoc() {
        return this.soc;
    } //getSoc

    public void setEnv(int n) {
        this.env = n;
    } //setEnv

    public void setEco(int n) {
        this.eco = n;
    } //setEco
    public void setSoc(int n) {
        this.soc = n;
    } //setSoc

    public Label getPrompt() {
        return this.prompt;
    } //getPrompt

    //maybe try using a seed file to initialize all the cards
    //need scanner class
    //s will be the file name to be passed in
    public void setDeck(String seedFile) {
        File file = new File(seedFile);
        try {
            Scanner cardCount = new Scanner(file);
            int cardNum = 0;
            while (cardCount.hasNextLine()) {
                cardNum++;
            } // while
            cardCount.close();
            Scanner promptCard = new Scanner(file);
            this.deck = new Card[cardNum];
            for (int i = 0; i < cardNum; i++) {
                this.deck[i].setPrompt(promptCard.nextLine());
                this.deck[i].setEnv(promptCard.nextInt());
                this.deck[i].setEco(promptCard.nextInt());
                this.deck[i].setSoc(promptCard.nextInt());
                this.deck[i].setPo(promptCard.nextInt());
            } // for
            promptCard.close();
        } catch (FileNotFoundException fnfe) {

        } //try
    } // setDeck
} //Game
