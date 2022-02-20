package com.example.javafxtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Label prompt;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Game game = new Game();
        BorderPane root = new BorderPane();

        ProgressBar eco = new ProgressBar();
        ProgressBar env = new ProgressBar();
        ProgressBar soc = new ProgressBar();
        eco.setRotate(90);
        env.setRotate(90);
        soc.setRotate(90);
        HBox bars = new HBox(eco, env, soc);

        Label prompt = game.getPrompt();
        Image image = new Image("file:src/main/resources/pngs/citygif.gif");
        ImageView imageHolder = new ImageView(image);
        //imageHolder.setFitWidth(500);
        imageHolder.setPreserveRatio(true);
        VBox imageBox = new VBox(imageHolder, prompt);
        imageBox.setAlignment(Pos.CENTER);

        //something to work on! (i can probably do this)
        //buttons not centered..
        HBox decision = new HBox();
        //decision.setAlignment(Pos.CENTER);
        decision.setFillHeight(true);
        decision.setAlignment(Pos.BOTTOM_CENTER);
        Button yes = new Button("Yes");
        //Region.positionInArea(yes,20,40,200,400,10,Insets.EMPTY,HPos.LEFT,VPos.CENTER,false);
        Button no = new Button("No");
        //Region.positionInArea(no,20,40,200,400,10,Insets.EMPTY,HPos.RIGHT,VPos.CENTER,false);
        HBox.setHgrow(yes, Priority.ALWAYS);
        HBox.setHgrow(no, Priority.ALWAYS);
        yes.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        no.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        //env eco soc bars need to be added
        EventHandler<ActionEvent> ae1 = T -> {
            game.run(true);
        };
        yes.setOnAction(ae1);
        EventHandler<ActionEvent> ae2 = T -> {
            game.run(false);
        };
        no.setOnAction(ae2);

        decision.getChildren().addAll(yes, no);
        root.setBottom(decision);
        root.setCenter(imageBox);
        root.setRight(bars);
        Scene scene = new Scene(fxmlLoader.load(), 600, 480);

        stage.setTitle("UGA-Hacks7");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}