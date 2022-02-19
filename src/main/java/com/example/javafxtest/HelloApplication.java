package com.example.javafxtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Label prompt;
    @Override
    public void start(Stage stage) {

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        Game game = new Game();
        VBox root = new VBox();

        Label prompt = game.getPrompt();
        Image image = new Image("file:src/main/resources/pngs/city_scape.png");
        ImageView imageHolder = new ImageView(image);
        //imageHolder.setFitWidth(500);
        imageHolder.setPreserveRatio(true);
        VBox imageBox = new VBox(imageHolder, prompt);
        imageBox.setAlignment(Pos.CENTER);

        HBox decision = new HBox();
        Button yes = new Button("Yes");
        Button no = new Button("No");

        EventHandler<ActionEvent> ae1 = T -> {
           game.run(true);
        };
        yes.setOnAction(ae1);
        EventHandler<ActionEvent> ae2 = T -> {
            game.run(false);
        };
        no.setOnAction(ae2);

        decision.getChildren().addAll(yes, no);
        root.getChildren().addAll(imageBox, decision);
        Scene scene = new Scene(root, 800, 640);

        stage.setTitle("UGA-Hacks7");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}