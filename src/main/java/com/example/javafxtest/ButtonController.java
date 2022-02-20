package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ButtonController implements Initializable {

    private Game game;
    @FXML
    private ImageView iv = new ImageView();
    //private Image image = new Image("file:src/main/resources/pngs/citygif.gif");
    @FXML private Label prompt;

    @FXML
    protected void onYesButtonClick(ActionEvent actionEvent) {
        game.run(true);
        this.prompt.setText(game.getPrompt().getText());
    } //onYesButtonClick

    @FXML
    protected void onNoButtonClick(ActionEvent actionEvent) {
        game.run(false);
        this.prompt.setText(game.getPrompt().getText());
    } //onNoButtonClick

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/resources/pngs/citygif.gif");
        Image image = new Image(file.toURI().toString());
        iv.setImage(image);
        this.game = new Game();
        this.prompt.setText(game.getPrompt().getText());
    } //initialize
}