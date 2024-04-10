package com.example.game_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.game_java.database.Database;
import java.sql.Connection;
import java.sql.SQLException;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Menu!");
        stage.setScene(scene);
        stage.show();
        connectDatabase();
    }

    public void connectDatabase(){
        try{
            Connection connection = Database.getConnection();
            System.out.println("marche");
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