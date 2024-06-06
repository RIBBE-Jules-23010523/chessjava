package com.example.echecsae.game.pieces;

import javafx.scene.image.Image;

import java.net.URL;

public class Piece {

    public int pieceColor;
    public int white = 0;
    public int black = 1;
    public int locationX;
    public int locationY;
    public Image image;
    public String name;

    public Piece(String name, String color, int pieceColor, int x, int y) {
        this.pieceColor = pieceColor;
        this.locationY = x;
        this.locationX = y;
        this.name = name;
        String imagePath = String.format("/com/example/echecsae/piece/%s_%s.png", name, color);
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            image = new Image(imageURL.toString());
        } else {
            System.err.println("Image not found: " + imagePath);
        }

    }


    public Image getImagePiece() {
        return image;
    }

    public boolean isValidMove(int i, int j) {
        return false;
    }
}
