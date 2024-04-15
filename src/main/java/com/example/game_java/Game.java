package com.example.game_java;

import com.example.game_java.controller.connection.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

import static com.example.game_java.Model.Database.getConnection;

public class Game extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("connection/login-view.fxml"));
        Scene login = new Scene(fxmlLoader.load(), 450, 600);
        stage.setTitle("Login");
        stage.setScene(login);
        stage.show();

        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);
    }

    public void connectDatabase(){
        try{
            Connection connection = getConnection();
            System.out.println("working");
            connection.close();
        } catch (SQLException e){
            System.err.println("error : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}