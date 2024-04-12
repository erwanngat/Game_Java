package com.example.game_java.controller;

import com.example.game_java.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onLoginButtonClick() {}

    @FXML
    protected void onRegisterRedirectClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("connection/register-view.fxml"));
        Scene register = new Scene(fxmlLoader.load(), 450, 600);
        Stage newStage = new Stage();
        newStage.setTitle("Register");
        newStage.setScene(register);
        newStage.show();
        stage.close();

        RegisterController controller = fxmlLoader.getController();
        controller.setStage(newStage);
    }
}