package com.example.game_java.controller;

import com.example.game_java.Game;
import com.example.game_java.database.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

public class RegisterController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }



    @FXML
    protected void onRegisterButtonClick() {
        openDatabaseConnection();
    }

    @FXML
    protected void onLoginRedirectClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("connection/connection-view.fxml"));
        Scene login = new Scene(fxmlLoader.load(), 450, 550);
        Stage newStage = new Stage();
        newStage.setTitle("Login");
        newStage.setScene(login);
        newStage.show();
        stage.close();

        LoginController controller = fxmlLoader.getController();
        controller.setStage(newStage);
    }
}
