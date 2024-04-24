package com.example.game_java.controller.selection;

import com.example.game_java.Model.User;
import com.example.game_java.Model.charClass.CharClass;
import com.example.game_java.Model.charClass.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class ClassSelectionController {

    private String classPass;
    @FXML
    public Label className;
    @FXML
    public Label defaultHP;
    @FXML
    public Label defaultDamage;
    @FXML
    public TextField charUsername;
    @FXML
    public Label usernameError;
    public Button choose;
    private final User user;


    public ClassSelectionController(String classPass, User user) {
        this.classPass = classPass;
        this.user = user;
    }

    public void initialize(){
        if (Objects.equals(this.classPass, "Warrior")){
            CharClass warrior = new CharClass(1, "warrior");
            className.setText("Warrior");
            defaultHP.setText(Integer.toString(warrior.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(warrior.getDefaultDamage()));
        }
        if (Objects.equals(this.classPass, "Rogue")){
            CharClass rogue = new CharClass(2, "rogue");
            className.setText("Rogue");
            defaultHP.setText(Integer.toString(rogue.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(rogue.getDefaultDamage()));
        }
        if (Objects.equals(this.classPass, "Wizard")){
            CharClass wizard = new CharClass(3, "wizard");
            className.setText("Wizard");
            defaultHP.setText(Integer.toString(wizard.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(wizard.getDefaultDamage()));
        }
        if (Objects.equals(this.classPass, "Archer")){
            CharClass archer = new CharClass(4, "archer");
            className.setText("Archer");
            defaultHP.setText(Integer.toString(archer.getDefaultHealthPoint()));
            defaultDamage.setText(Integer.toString(archer.getDefaultDamage()));
        }
    }

    public void chooseClass(ActionEvent event){
        String username = charUsername.getText();
        if (username == null || username.isEmpty()){
            usernameError.setText("You must choose an username");
            return;
        }
        CharClass charClass = switch (this.classPass) {
            case "Warrior" -> new CharClass(1, "warrior");
            case "Rogue" -> new CharClass(2, "rogue");
            case "Wizard" -> new CharClass(3, "wizard");
            case "Archer" -> new CharClass(4, "archer");
            default -> throw new IllegalArgumentException("Invalid classPass value: " + this.classPass);
        };
        Character character = new Character(username, charClass.getId(), 1, charClass.getDefaultHealthPoint(), charClass.getDefaultHealthPoint(), charClass.getDefaultDamage());
        character.saveCharacter(character, user);
    }
}
