package com.example.game_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.game_java.database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.IOException;

public class Game extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("connection/connection-view.fxml"));
        Scene login = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Login");
        stage.setScene(login);
        stage.show();
    }

    public void connectDatabase(){
        try{
            Connection connection = Database.getConnection();
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