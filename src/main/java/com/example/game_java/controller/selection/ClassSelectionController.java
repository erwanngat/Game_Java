package com.example.game_java.controller.selection;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Objects;

public class ClassSelectionController {

    private String classPass;
    @FXML
    public Label className;

    public ClassSelectionController(String classPass) {
        this.classPass = classPass;
    }

    public void initialize(){
        if (Objects.equals(this.classPass, "Warrior")){
            className.setText("Warrior");
        }
        if (Objects.equals(this.classPass, "Rogue")){
            className.setText("Rogue");
        }
        if (Objects.equals(this.classPass, "Wizard")){
            className.setText("Wizard");
        }
        if (Objects.equals(this.classPass, "Archer")){
            className.setText("Archer");
        }
    }
}
