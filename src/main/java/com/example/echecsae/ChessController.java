package com.example.echecsae;

import com.example.echecsae.game.ChessPlate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChessController {
    @FXML
    private AnchorPane chessContainer;
    @FXML
    private ChessPlate chessPlate;

    @FXML
    private Label joueur1;

    @FXML
    public void initialize() {
        chessPlate = new ChessPlate();
        chessContainer.getChildren().add(chessPlate.getBoard());
    }

    @FXML
    public void handlePlayersClick(MouseEvent event) {
        loadThirdView();
    }
    @FXML
    public void handleNewGameClick(MouseEvent event) {
        loadPrimaryView();
    }
    @FXML
    public void handleGamesClick(MouseEvent event) {
        loadSecondaryView();
    }

    public void loadSecondaryView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GamesView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) joueur1.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadThirdView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) joueur1.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPrimaryView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChessView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) joueur1.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}