package com.example.echecsae;

import com.example.echecsae.game.ChessPlate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ChessApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ChessPlate board = new ChessPlate();
        Scene scene = new Scene(new BorderPane(board.getBoard()), 800, 800);
        stage.setResizable(true);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}