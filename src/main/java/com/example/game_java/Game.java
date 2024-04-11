package com.example.game_java;

import com.example.game_java.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

import static com.example.game_java.database.Database.getConnection;

public class Game extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("connection/connection-view.fxml"));
        Scene login = new Scene(fxmlLoader.load(), 450, 550);
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