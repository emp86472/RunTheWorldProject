package com.example.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView imageHolder;
    private Image image = new Image("file:src/main/resources/pngs/mobilelaptop.png");

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        //System.out.println("this code is ran!");
        imageHolder = new ImageView(image);
        imageHolder.setFitWidth(500);
        imageHolder.setPreserveRatio(true);

    }
}