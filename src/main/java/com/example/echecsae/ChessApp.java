package com.example.echecsae;

import com.example.echecsae.game.ChessPlate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Cette classe représente l'application de jeu d'échecs.
 */
public class ChessApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChessApp.class.getResource("ChessView.fxml"));
        ChessController controller = new ChessController();
        ChessPlate board = new ChessPlate(controller);
        Scene scene = new Scene(fxmlLoader.load(), 1280, 920);
        stage.setResizable(true);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}