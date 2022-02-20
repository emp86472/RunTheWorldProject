package com.example.javafxtest;

import javafx.scene.control.Label;

import java.util.Random;

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
        this.card = new Card(0,0,0);
        this.setDeck();
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
    public void setDeck() {
        //something to work on!
        //someone needs to create the seed file with all the cards
        //seed file should be in some parsable format
        //someone else can play ar with scanners to initialize all the cards using a forloop
        Card card1 = new Card(10, 10, 10);
        card1.setPrompt("example prompt 1");
        Card card2 = new Card(-10,-10,-10);
        card2.setPrompt("prompt example 2");
        this.deck = new Card[]{card1, card2};
    }
} //Game
