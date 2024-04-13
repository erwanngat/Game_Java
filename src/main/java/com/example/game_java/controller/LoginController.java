package com.example.game_java.controller;

import com.example.game_java.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.game_java.Model.UserDAO.loginUser;

public class LoginController {

    public TextField emailField;
    public PasswordField passwordField;
    public Label errorLabel;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onLoginButtonClick() {
        if (!loginUser(emailField.getText(), passwordField.getText())){
            errorLabel.setText("Invalid email or password.");
        } else {
            System.out.println("pass");
        }
    }

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