package com.example.game_java.controller.selection;

import com.example.game_java.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class CharacterSelectionController {

    private String buttonId;
    private Stage stage;
    @FXML
    public ImageView Warrior;
    @FXML
    public ImageView Rogue;
    @FXML
    public ImageView Wizard;
    @FXML
    public ImageView Archer;

    public CharacterSelectionController(String buttonid){
        this.buttonId = buttonid;
    }

    public void setStage(Stage newStage) {
        this.stage = newStage;
    }


    @FXML
    public void onSelectedClass(MouseEvent event) throws IOException {
        ImageView CharClass = (ImageView) event.getTarget();
        String className = CharClass.getId();

        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("selection/class-selection-view.fxml"));
        ClassSelectionController controller = new ClassSelectionController(className);
        fxmlLoader.setController(controller);
        Scene classSelection = new Scene(fxmlLoader.load(), 450, 600);
        Stage newStage = new Stage();
        newStage.setTitle("Class selection");
        newStage.setScene(classSelection);
        newStage.show();
    }

}
