package com.example.game_java.controller.selection;

import com.example.game_java.Game;
import com.example.game_java.Model.User;
import com.example.game_java.Model.charClass.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class MenuController {

    public Button slot1;
    public Button slot2;
    public Button slot3;
    public Label labelSlot1;
    public Label labelSlot2;
    public Label labelSlot3;
    public Label labelLevelSlot1;
    public Label labelLevelSlot2;
    public Label labelLevelSlot3;
    private Stage stage;
    private final User user;

    public void initialize() throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        List<Character> characters = this.user.getCharacter();
        if (characters.isEmpty()){
            return;
        }else{
            int cpt = 1;
            for (Character character : characters){
                String name = character.getName();
                String charClass = character.getCharClassName(character.getCharClass());
                int level = character.getLevel();

                String dynamicButtonLabelName = "slot" + cpt;
                Button dynamicButtonLabel = (Button) this.getClass().getDeclaredField(dynamicButtonLabelName).get(this);

                dynamicButtonLabel.setFont(new Font(20));
                dynamicButtonLabel.setText("Name : " + name);

                String dynamicLabelName = "labelSlot" + cpt;
                Label dynamicLabel = (Label) this.getClass().getDeclaredField(dynamicLabelName).get(this);

                dynamicLabel.setFont(new Font(20));
                dynamicLabel.setText("CLass : " + charClass);

                String dynamicLabelLevel = "labelLevelSlot" + cpt;
                Label dynamicLabelLvl = (Label) this.getClass().getDeclaredField(dynamicLabelLevel).get(this);

                dynamicLabelLvl.setText("Level : " + level);
                cpt++;
            }
        }
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
        CharacterSelectionController controller = new CharacterSelectionController(buttonId, user);
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
