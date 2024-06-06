package com.example.echecsae.game;

import com.example.echecsae.game.pieces.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ChessPlate {

    private final VBox board;
    private Piece[][] posPiece;
    public Piece selectedPiece; // Variable pour mémoriser la pièce sélectionnée

    public ChessPlate() {
        board = new VBox();
        createBoard();
        placePieces();
    }
    //Création de l'échiquier
    private void createBoard() {
        for (int i = 0; i < 8; i++) {
            HBox row = new HBox();
            for (int j = 0; j < 8; j++) {
                StackPane square = new StackPane();
                square.setMinHeight(100);
                square.setMinWidth(100);
                if ((i + j) % 2 == 0) {
                    square.setStyle("-fx-background-color: #EEEED5");
                } else {
                    square.setStyle("-fx-background-color: #7D945D");
                }
                row.getChildren().add(square);
            }
            board.getChildren().add(row);
        }
    }

    public VBox getBoard() {
        return board;
    }

    //Permet de placer les pièces sur l'échiquier avec le format suivant: new ClasseDeLaPiece{nom, couleur, x, y} (nom et couleurs permettent de sélectionner la bonne image
    public void placePieces() {
        posPiece = new Piece[][]{
                {new Rook("rook", "black", 1, 0, 0), new Knight("knight", "black", 1, 1, 0), new Bishop("bishop", "black", 1, 2, 0), new Queen("queen", "black", 1, 3, 0), new King("king", "black", 1, 4, 0), new Bishop("bishop", "black", 1, 5, 0), new Knight("knight", "black", 1, 6, 0), new Rook("rook", "black", 1, 7, 0)},
                {/*new Pawn("pawn", "black", 1, 0, 1)*/null, new Pawn("pawn", "black", 1, 1, 1), new Pawn("pawn", "black", 1, 2, 1), new Pawn("pawn", "black", 1, 3, 1), new Pawn("pawn", "black", 1, 4, 1), new Pawn("pawn", "black", 1, 5, 1), new Pawn("pawn", "black", 1, 6, 1), new Pawn("pawn", "black", 1, 7, 1)},
                {null, null, null, null, null, null, null, null},
                {new Rook("rook", "white", 0,0,3), null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {/*new Pawn("pawn", "white", 0, 0, 6)*/null, new Pawn("pawn", "white", 0, 1, 6), new Pawn("pawn", "white", 0, 2, 6), new Pawn("pawn", "white", 0, 3, 6), new Pawn("pawn", "white", 0, 4, 6), new Pawn("pawn", "white", 0, 5, 6), new Pawn("pawn", "white", 0, 6, 6), new Pawn("pawn", "white", 0, 7, 6)},
                {new Rook("rook", "white", 0, 0, 7), new Knight("knight", "white", 0, 1, 7), new Bishop("bishop", "white", 0, 2, 7), new Queen("queen", "white", 0, 3, 7), new King("king", "white", 0, 4, 7), new Bishop("bishop", "white", 0, 5, 7), new Knight("knight", "white", 0, 6, 7), new Rook("rook", "white", 0, 7, 7)}
        };

        updateBoard();
    }

    public Piece getPiece(int x, int y) {
        return posPiece[x][y];
    }


    private void updateBoard() {
        for (int i = 0; i < 8; i++) {
            HBox row = (HBox) board.getChildren().get(i);
            for (int j = 0; j < 8; j++) {
                StackPane square = (StackPane) row.getChildren().get(j);
                square.getChildren().clear();
                Piece piece = posPiece[i][j];
                if (piece != null) {
                    ImageView pieceView = new ImageView(piece.getImagePiece());
                    pieceView.setFitWidth(90);
                    pieceView.setFitHeight(90);
                    pieceView.setUserData(piece);
                    square.getChildren().add(pieceView);
                }

                // Ajout d'un gestionnaire d'événements pour détecter le clic sur une case
                int finalJ = j;
                int finalI = i;
                square.setOnMouseClicked(event -> handleSquareClick(finalI, finalJ));
            }
        }
    }

    private void handleSquareClick(int i, int j) {
        Piece piece = posPiece[i][j];

        if (selectedPiece == null) {
            // Premier clic : sélection de la pièce
            if (piece != null) {
                selectedPiece = piece; // Mémorisation de la pièce sélectionnée
                System.out.println("Piece selected at: " + selectedPiece.locationX + ", " + selectedPiece.locationY);
                System.out.println("Piece selected: " + selectedPiece.name);
                String color = (selectedPiece.pieceColor == 0) ? "white" : "black";
                System.out.println("Piece color: " + color + "\n");
            }
        } else {
            // Deuxième clic : vérification du mouvement et déplacement de la pièce
            if (piece == null && selectedPiece.isValidMove(i, j)) {
                System.out.println("The move is valid.");
                // Supprimer l'instance de la pièce de sa position actuelle
                posPiece[selectedPiece.locationX][selectedPiece.locationY] = null;
                // Mettre à jour les coordonnées de la pièce
                selectedPiece.locationX = j;
                selectedPiece.locationY = i;
                // Ajouter la pièce aux nouvelles coordonnées
                posPiece[i][j] = selectedPiece;
                // Mettre à jour le plateau
                updateBoard();
                // Réinitialiser la pièce sélectionnée
                selectedPiece = null;
            } else {
                System.out.println("The move is not valid.");
                // Réinitialiser la pièce sélectionnée
                selectedPiece = null;
            }
        }
    }

}

