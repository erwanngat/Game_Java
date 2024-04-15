package com.example.game_java.controller.connection;

import com.example.game_java.Game;
import com.example.game_java.Model.User;
import com.example.game_java.controller.game.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import static com.example.game_java.Model.UserDAO.getUserByEmail;
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
    protected void onLoginButtonClick() throws IOException {
        if (!loginUser(emailField.getText(), passwordField.getText())){
            errorLabel.setText("Invalid email or password.");
        } else {
            User user = getUserByEmail(emailField.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("game/menu-view.fxml"));
            MenuController controller = new MenuController(user);
            fxmlLoader.setController(controller);
            Scene menu = new Scene(fxmlLoader.load(), 1920, 1080);
            Stage newStage = new Stage();
            newStage.setTitle("Menu");
            newStage.setScene(menu);
            newStage.show();
            stage.close();

            controller.setStage(newStage);
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