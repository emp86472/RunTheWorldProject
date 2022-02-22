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
 * New Cards! Cards with more flavor
 */
public class Game {
    private int env, eco, soc, po;
    //po for public opinion
    private static int decisionCount;
    private Card[] deck;
    private Label prompt = new Label();
    private Card card;
    boolean isLoss = false;
    Random r = new Random();

    public Game() {
        prompt.setText("Welcome to Run The World! Click any button to play");
        this.setDeck("src/main/resources/seed.txt");
        this.card = new Card(0,0,0,0);
        card.setPrompt("");
        this.env = 50;
        this.eco = 50;
        this.soc = 50;
        this.po = 50;
    } //Game constructor

    //main game loop
    public void run(boolean decision) {
        int env = this.card.getEnv();
        int eco = this.card.getEco();
        int soc = this.card.getSoc();
        if (decision) {
            this.env += env;
            this.eco += eco;
            this.soc += soc;
            //this.po += 10;
        } else {
            this.env -= env;
            this.eco -= eco;
            this.soc -= soc;
        } //if
        this.env = max(this.env, 100);
        this.eco = max(this.eco, 100);
        this.soc = max(this.soc, 100);
        //this.po = max(this.po, 100);

        this.env = min(this.env, 0);
        this.eco = min(this.eco, 0);
        this.soc = min(this.soc, 0);
        //this.po = min(this.po, 0);

        this.card = this.deck[r.nextInt(deck.length)];
        if (this.env > 0 && this.eco > 0 && this.soc > 0) {
            String prompt = card.getPrompt();
            this.prompt.setText(prompt);
            decisionCount++;
        } else {
            this.isLoss = true;
            this.prompt.setText("Game Over! Play again?");
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

    public int getPo() {
        return this.po;
    } //getPo

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

    public boolean getLoss() { return this.isLoss; } //isLoss

    public void setLoss(boolean b) { this.isLoss = b; } //setLoss

    public Card getCard() { return this.card; } //getCard

    //maybe try using a seed file to initialize all the cards
    //need scanner class
    //s will be the file name to be passed in
    public void setDeck(String seedFile) {
        File file = new File(seedFile);
        try {
            Scanner cardCount = new Scanner(file);
            int cardNum = 0;
            while (!cardCount.nextLine().equals("#")) {
                cardNum++;
            } // while
            cardNum /= 2;
            cardCount.close();
            Scanner promptCard = new Scanner(file);
            this.deck = new Card[cardNum];
            for (int i = 0; i < cardNum; i++) {
                this.deck[i] = new Card();
                this.deck[i].setPrompt(promptCard.nextLine());
                String s = promptCard.nextLine();
                Scanner nums = new Scanner(s);
                this.deck[i].setEnv(nums.nextInt());
                this.deck[i].setEco(nums.nextInt());
                this.deck[i].setSoc(nums.nextInt());
                //this.deck[i].setPo(nums.nextInt());
            } // for
            promptCard.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("We ain't seein a file, chief");
        } //try
    } // setDeck

    public static int max(int a, int b) {
        if (a >= b) {
            a = b;
        } //if
        return a;
    } //max

    public static int min(int a, int b) {
        if (a <= b) {
            a = b;
        } //if
        return a;
    } //max
} //Game
