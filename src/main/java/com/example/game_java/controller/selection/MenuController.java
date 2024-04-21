package com.example.game_java.controller.selection;

import com.example.game_java.Game;
import com.example.game_java.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {

    public Button slot1;
    public Button slot2;
    public Button slot3;
    public Label labelSlot1;
    public Label labelSlot2;
    public Label labelSlot3;
    private Stage stage;
    private final User user;

    public void initialise(){

    }

    public MenuController(User user) {
        this.user = user;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void onNewCharacterButton(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        String buttonId = button.getId();

        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("selection/character-selection-view.fxml"));
        CharacterSelectionController controller = new CharacterSelectionController(buttonId);
        fxmlLoader.setController(controller);
        Scene characterSelection = new Scene(fxmlLoader.load(), 1920, 1080);
        Stage newStage = new Stage();
        newStage.setTitle("Character selection");
        newStage.setScene(characterSelection);
        newStage.show();
        stage.close();

        controller.setStage(newStage);
    }
}
