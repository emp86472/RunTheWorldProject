package com.example.javafxtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ButtonController implements Initializable {

    private Game game;
    @FXML
    private ImageView iv = new ImageView();
    //private Image image = new Image("file:src/main/resources/pngs/citygif.gif");
    @FXML private Label prompt;
    @FXML private ProgressBar eco;
    @FXML private ProgressBar env;
    @FXML private ProgressBar soc;
    //@FXML private ProgressBar po;
    @FXML private VBox box = new VBox();

    @FXML
    protected void onYesButtonClick(ActionEvent actionEvent) {
        if (game.getLoss()) {
            game.setEco(50);
            game.setEnv(50);
            game.setSoc(50);
            Card card = game.getCard();
            card.setEco(0);
            card.setEnv(0);
            card.setSoc(0);
            game.setLoss(false);
        } //if
        game.run(true);
        this.prompt.setText(game.getPrompt().getText());
        eco.setProgress((double)game.getEco()/100);
        env.setProgress((double)game.getEnv()/100);
        soc.setProgress((double)game.getSoc()/100);
        //po.setProgress((double)game.getPo()/100);
    } //onYesButtonClick

    @FXML
    protected void onNoButtonClick(ActionEvent actionEvent) {
        if (game.getLoss()) {
            System.exit(0);
        } //if
        game.run(false);
        this.prompt.setText(game.getPrompt().getText());
        eco.setProgress((double)game.getEco()/100);
        env.setProgress((double)game.getEnv()/100);
        soc.setProgress((double)game.getSoc()/100);
        //po.setProgress((double)game.getPo()/100);
    } //onNoButtonClick

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/resources/pngs/citygif.gif");
        File file2 = new File("src/main/resources/pngs/grey.png");
        Image image = new Image(file.toURI().toString());
        Image image2 = new Image(file2.toURI().toString());
        iv.setImage(image);
        this.box.setBackground(new Background(new BackgroundImage(image2,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
        this.game = new Game();
        this.prompt.setText(game.getPrompt().getText());
        this.prompt.setWrapText(true);
        eco.setProgress((double)game.getEco()/100);
        env.setProgress((double)game.getEnv()/100);
        soc.setProgress((double)game.getSoc()/100);
        //po.setProgress((double)game.getPo()/100);
    } //initialize
}