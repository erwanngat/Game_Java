package com.example.game_java.controller;

import com.example.game_java.Game;
import com.example.game_java.Model.Database;
import com.example.game_java.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.regex.Pattern;

import static com.example.game_java.Model.UserDAO.createUser;

public class RegisterController {

    private final Database database = new Database();
    private Stage stage;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordConfirmationField;
    @FXML
    private Label errorLabel;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private boolean checkEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null){
            return false;
        }
        return pat.matcher(email).matches();
    }

    @FXML
    protected void onRegisterButtonClick() {
        String email = emailField.getText();
        String password = passwordField.getText();
        String passwordConfirmation = passwordConfirmationField.getText();

        if (!checkEmail(email) && !password.equals(passwordConfirmation)){
            errorLabel.setText("The email address is not valid and the passwords do not match.");
        } else if (!checkEmail(email)) {
            errorLabel.setText("The email address is not valid.");
        } else if (password.isEmpty()){
            errorLabel.setText("The passwords could not be empty.");
        } else if (!password.equals(passwordConfirmation)) {
            errorLabel.setText("The passwords do not match.");
        }


        if (checkEmail(email) && password.equals(passwordConfirmation) && !password.isEmpty()){
            User user = new User(email, password, passwordConfirmation);
            createUser(user);
        }
    }

    @FXML
    protected void onLoginRedirectClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("connection/connection-view.fxml"));
        Scene login = new Scene(fxmlLoader.load(), 450, 600);
        Stage newStage = new Stage();
        newStage.setTitle("Login");
        newStage.setScene(login);
        newStage.show();
        stage.close();

        LoginController controller = fxmlLoader.getController();
        controller.setStage(newStage);
    }
}
