package com.example.game_java.controller;

import com.example.game_java.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class RegisterController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    protected void onLoginRedirectClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("connection/connection-view.fxml"));
        Scene register = new Scene(fxmlLoader.load(), 500, 500);
        Stage newStage = new Stage();
        newStage.setTitle("Login");
        newStage.setScene(register);
        newStage.show();
        stage.close();

        LoginController controller = fxmlLoader.getController();
        controller.setStage(newStage);
    }
}
