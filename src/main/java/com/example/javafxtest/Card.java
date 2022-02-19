package com.example.javafxtest;

public class Card {

    String prompt;
    private int env, eco, soc;

    public Card(int x, int y, int z) {
        this.env = x;
        this.eco = y;
        this.soc = z;
    } //Card

    public String getPrompt() {
        return this.prompt;
    } //getPrompt

    public void setPrompt(String s) {
        this.prompt = s;
    } // setPrompt

    public int getEnv() {
        return this.env;
    } //getEnv

    public int getEco() {
        return this.eco;
    } //getEco

    public int getSoc() {
        return this.soc;
    } //getSoc
} //Card
