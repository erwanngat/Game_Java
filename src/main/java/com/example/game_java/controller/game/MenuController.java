package com.example.game_java.controller.game;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class MenuController {

    public Button slot1;
    public Button slot2;
    public Button slot3;
    public Label labelSlot1;
    public Label labelSlot2;
    public Label labelSlot3;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void onNewCharacterButton(ActionEvent actionEvent) {
        System.out.println("new char");
    }
}
