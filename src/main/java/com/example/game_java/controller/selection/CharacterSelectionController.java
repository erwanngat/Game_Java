package com.example.game_java.controller.selection;

import javafx.stage.Stage;

import javafx.scene.control.Label;

public class CharacterSelectionController {

    private String buttonId;
    private Stage stage;

    public CharacterSelectionController(String buttonid){
        this.buttonId = buttonid;
    }

    public void setStage(Stage newStage) {
        this.stage = newStage;
    }

}
