package com.example.javafxtest;

public class Card {

    String prompt;

    private int env, eco, soc, po;

    public Card() {

    }//

    public Card(int a, int b, int c ,int d) {
        this.env = a;
        this.eco = b;
        this.soc = c;
        this.po = d;
    } //constructor

    public String getPrompt() {
        return this.prompt;
    } //getPrompt

    public void setPrompt(String s) {
        this.prompt = s;
    } // setPrompt

    public void setEnv(int a) { this.env = a; }

    public void setEco(int b) { this.eco = b; }

    public void setSoc(int c) { this.soc = c; }

    public void setPo(int d) { this.po = d; }

    public int getEnv() {
        return this.env;
    } //getEnv

    public int getEco() {
        return this.eco;
    } //getEco

    public int getSoc() {
        return this.soc;
    } //getSoc

    public int getOp() { return this.po; } //getOp
} //Card
