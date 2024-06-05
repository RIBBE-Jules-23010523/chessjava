package com.example.echecsae.game.pieces;

import javafx.scene.image.Image;

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
        this.locationX = x;
        this.locationY = y;
        this.name = name;
        String imagePath = String.format("/%s_%s.png", name, color);
        image = new Image(getClass().getResource(imagePath).toString());
    }


    public Image getImagePiece() {
        return image;
    }

}
