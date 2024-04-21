package com.example.game_java.controller.selection;

import com.example.game_java.Model.charClass.CharClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Objects;

public class ClassSelectionController {

    private String classPass;
    @FXML
    public Label className;
    @FXML
    public Label defaultHP;
    @FXML
    public Label defaultDamage;
    public Button choose;

    public ClassSelectionController(String classPass) {
        this.classPass = classPass;
    }

    public void initialize(){
        if (Objects.equals(this.classPass, "Warrior")){
            CharClass warrior = new CharClass("warrior");
            className.setText("Warrior");
            defaultHP.setText(Integer.toString(warrior.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(warrior.getDefaultDamage()));
        }
        if (Objects.equals(this.classPass, "Rogue")){
            CharClass rogue = new CharClass("rogue");
            className.setText("Rogue");
            defaultHP.setText(Integer.toString(rogue.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(rogue.getDefaultDamage()));
        }
        if (Objects.equals(this.classPass, "Wizard")){
            CharClass wizard = new CharClass("wizard");
            className.setText("Wizard");
            defaultHP.setText(Integer.toString(wizard.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(wizard.getDefaultDamage()));
        }
        if (Objects.equals(this.classPass, "Archer")){
            CharClass archer = new CharClass("archer");
            className.setText("Archer");
            defaultHP.setText(Integer.toString(archer.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(archer.getDefaultDamage()));
        }
    }

    public void chooseClass(ActionEvent event){
        System.out.println("choosing");
    }
}
