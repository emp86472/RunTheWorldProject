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
    Random r = new Random();

    //lets say the cap is 100
    public Game() {
        prompt.setText("Click yes to play!");
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
        Card card = this.deck[r.nextInt(deck.length)];
        int env = card.getEnv();
        int eco = card.getEco();
        int soc = card.getSoc();
        if (this.env >= 0 && this.eco >= 0 && this.soc >= 0) {
            String prompt = card.getPrompt();
            this.prompt.setText(prompt);
            if (decision) {
                this.env += env;
                this.eco += eco;
                this.soc += soc;
                this.po += po;
            } else {
                //stuff
            } //if
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
    public void setDeck(String seedFile) {
        File file = new file(seedFile); // seed file given in param
        Scanner promptNum = new scanner(file);
        numCards = 0; // records num of cards
        while (promptNum.hasNextLine()) { // reads the amount of cards
            number of cards += 1;
        } // while
        promptNum.close();
        this.deck = new Card[numCards];
        Scanner promptReader = new Scanner(file);
        for (int i = 0; i < numCards; i++) {
            this.deck[i].setprompt(promptReader.nextline());
            this.deck[i].setEnv(promptReader.nextInt());
            this.deck[i].setEco(promptReader.nextInt());
            this.deck[i].setSoc(promptReader.nextInt());
            this.deck[i].setPo(promptReader.nextInt());
        } // for
    } // setDeck
} //Game
