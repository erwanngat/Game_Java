package com.example.game_java.controller;

import com.example.game_java.Game;
import com.example.game_java.Model.Database;
import com.example.game_java.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;

import static com.example.game_java.Model.UserDAO.createUser;

public class RegisterController {

    private final Database database = new Database();
    private Stage stage;
    @FXML
    public TextField emailField;
    @FXML
    public PasswordField passwordField;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onRegisterButtonClick() {
        String email = emailField.getText();
        String password = passwordField.getText();
        User user = new User(email, password);
        createUser(user);
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
