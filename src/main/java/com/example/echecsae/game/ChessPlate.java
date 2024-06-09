package com.example.echecsae.game;

import com.example.echecsae.ChessController;
import com.example.echecsae.game.pieces.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Cette classe représente l'échiquier du jeu d'échecs.
 */
public class ChessPlate {
    private int tour;
    private final VBox board;
    private Piece[][] posPiece;
    public Piece selectedPiece;
    private boolean gameOver = false;
    private ChessController controller;


    /**
     * Constructeur de la classe ChessPlate.
     */
    public ChessPlate(ChessController controller) {
        this.controller = controller;
        board = new VBox();
        tour = 0;
        createBoard();
        placePieces();
    }

    /**
     * Cette méthode crée l'échiquier.
     */
    private void createBoard() {
        for (int i = 0; i < 8; i++) {
            HBox row = new HBox();
            for (int j = 0; j < 8; j++) {
                StackPane square = new StackPane();
                square.setMinHeight(80);
                square.setMinWidth(80);
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

    /**
     * Cette méthode retourne l'échiquier.
     * @return l'échiquier.
     */
    public VBox getBoard() {
        return board;
    }

    /**
     * Cette méthode place les pièces sur l'échiquier.
     * Les pièces sont placées dans un tableau bidimensionnel.
     * Les cases vides sont représentées par la valeur null.
     */
    public void placePieces() {
        posPiece = new Piece[][]{
                {new Rook("rook", "black", 1, 0, 0), new Knight("knight", "black", 1, 0, 1), new Bishop("bishop", "black", 1, 0, 2), new Queen("queen", "black", 1, 0, 3), new King("king", "black", 1, 0, 4), new Bishop("bishop", "black", 1, 0, 5), new Knight("knight", "black", 1, 0, 6), new Rook("rook", "black", 1, 0, 7)},
                {new Pawn("pawn", "black", 1, 1, 0), new Pawn("pawn", "black", 1, 1, 1), new Pawn("pawn", "black", 1, 1, 2), new Pawn("pawn", "black", 1, 1, 3), new Pawn("pawn", "black", 1, 1, 4), new Pawn("pawn", "black", 1, 1, 5), new Pawn("pawn", "black", 1, 1, 6), new Pawn("pawn", "black", 1, 1, 7)},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {new Pawn("pawn", "white", 0, 6, 0), new Pawn("pawn", "white", 0, 6, 1), new Pawn("pawn", "white", 0, 6, 2), new Pawn("pawn", "white", 0, 6, 3), new Pawn("pawn", "white", 0, 6, 4), new Pawn("pawn", "white", 0, 6, 5), new Pawn("pawn", "white", 0, 6, 6), new Pawn("pawn", "white", 0, 6, 7)},
                {new Rook("rook", "white", 0, 7, 0), new Knight("knight", "white", 0, 7, 1), new Bishop("bishop", "white", 0, 7, 2), new Queen("queen", "white", 0, 7, 3), new King("king", "white", 0, 7, 4), new Bishop("bishop", "white", 0, 7, 5), new Knight("knight", "white", 0, 7, 6), new Rook("rook", "white", 0, 7, 7)}
        };

        updateBoard();
    }

    /**
     * Cette méthode retourne la pièce à une position donnée.
     * @param x la position x de la pièce.
     * @param y la position y de la pièce.
     * @return la pièce à la position donnée.
     */
    public Piece getPiece(int x, int y) {
        return posPiece[x][y];
    }

    /**
     * Cette méthode met à jour l'échiquier.
     */
    private void updateBoard() {
        for (int i = 0; i < 8; i++) {
            HBox row = (HBox) board.getChildren().get(i);
            for (int j = 0; j < 8; j++) {
                StackPane square = (StackPane) row.getChildren().get(j);
                square.getChildren().clear();
                Piece piece = posPiece[i][j];
                if (piece != null) {
                    ImageView pieceView = new ImageView(piece.getImagePiece());
                    pieceView.setFitWidth(65);
                    pieceView.setFitHeight(65);
                    pieceView.setUserData(piece);
                    square.getChildren().add(pieceView);
                }

                int finalJ = j;
                int finalI = i;
                square.setOnMouseClicked(event -> handleSquareClick(finalI, finalJ));
            }
        }
    }

    /**
     * Cette méthode gère le clic sur une case de l'échiquier.
     * @param j la position x de la case.
     * @param i la position y de la case.
     */
    private void handleSquareClick(int i, int j) {
        if (gameOver) {
            return;
        }

        Piece piece = posPiece[i][j];
        if (selectedPiece == null) {
            if (piece != null && piece.getColor() == tour) {
                selectedPiece = piece;
                clearHighlights();
                highlightValidMoves(selectedPiece);
            }
        } else {
            if (piece == selectedPiece && selectedPiece.getColor() == tour) {
                // Si la même pièce est cliquée à nouveau, annuler la sélection
                selectedPiece = null;
                clearHighlights();
            } else if (piece != null && selectedPiece.isSameColor(piece) && selectedPiece.getColor() == tour) {
                selectedPiece = piece;
                clearHighlights();
                highlightValidMoves(selectedPiece);
            } else {
                int[][] validMoves = selectedPiece.validMoves(this);
                boolean isValid = false;
                for (int[] move : validMoves) {
                    if (move[0] == i && move[1] == j) {
                        isValid = true;
                        break;
                    }
                }
                if (isValid && selectedPiece.getColor() == tour) {
                    if (piece != null && piece.toString().equals("King")) {
                        System.out.println("Le roi a été mangé. Fin du jeu.");
                        controller.endGame(tour == 0 ? "Les blancs ont gagné ! " : "Les noirs ont gagné !");
                        gameOver = true;
                    }
                    posPiece[selectedPiece.getX()][selectedPiece.getY()] = null;
                    selectedPiece.setX(i);
                    selectedPiece.setY(j);
                    posPiece[i][j] = selectedPiece;
                    selectedPiece = null;
                    clearHighlights();
                    updateBoard();
                    // Changer le tour
                    tour = (tour == 0) ? 1 : 0;
                }
            }
        }
        System.out.println("Piece selected: " + (selectedPiece != null ? selectedPiece.toString() : "None"));
        System.out.println("Piece at: " + i + ", " + j);
    }

    private void highlightValidMoves(Piece piece) {
        if (piece == null) return;

        int[][] validMoves = piece.validMoves(this);
        for (int[] move : validMoves) {
            int i = move[0];
            int j = move[1];
            StackPane square = (StackPane) ((HBox) board.getChildren().get(i)).getChildren().get(j);
            square.setStyle("-fx-background-color: #f4f67f");
        }
        StackPane selectedSquare = (StackPane) ((HBox) board.getChildren().get(piece.getX())).getChildren().get(piece.getY());
        selectedSquare.setStyle("-fx-background-color: #bdcc3c");
    }

    private void clearHighlights() {
        for (int i = 0; i < 8; i++) {
            HBox row = (HBox) board.getChildren().get(i);
            for (int j = 0; j < 8; j++) {
                StackPane square = (StackPane) row.getChildren().get(j);
                if ((i + j) % 2 == 0) {
                    square.setStyle("-fx-background-color: #EEEED5");
                } else {
                    square.setStyle("-fx-background-color: #7D945D");
                }
            }
        }
    }
}
