package com.example.javafxtest;

import javafx.scene.control.Label;

import java.util.Random;

public class Game {
    private int env, eco, soc, po;
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
                this.po += 10;
            } else {
                this.po -= 10;
            } //if
            decisionCount++;
        } else {
            System.exit(0);
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

    //maybe try using a seed file
    public void setDeck() {
        Card card1 = new Card(10, 10, 10);
        card1.setPrompt("example prompt 1");
        Card card2 = new Card(-10,-10,-10);
        card2.setPrompt("prompt example 2");
        this.deck = new Card[]{card1, card2};
    }
} //Game
