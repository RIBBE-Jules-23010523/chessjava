package com.example.echecsae.game.pieces;

import com.example.echecsae.game.ChessPlate;
import javafx.scene.image.Image;

import java.net.URL;

/**
 * Cette classe abstraite représente une pièce du jeu d'échecs.
 */
public abstract class Piece {
    private Image image;
    private int couleur;
    private int x;
    private int y;
    private String name;
    protected int pieceColor;


    /**
     * Constructeur de la classe Piece.
     * @param name le nom de la pièce.
     * @param color la couleur de la pièce.
     * @param couleur le code couleur de la pièce.
     * @param x la position x de la pièce.
     * @param y la position y de la pièce.
     */
    public Piece(String name, String color, int couleur, int x, int y) {
        this.couleur = couleur;
        this.x = x;
        this.y = y;
        this.name = name;
        String imagePath = String.format("/com/example/echecsae/piece/%s_%s.png", name, color);
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            image = new Image(imageURL.toString());
        } else {
            System.err.println("Image not found: " + imagePath);
        }
    }

    /**
     * Cette méthode retourne l'image de la pièce.
     * @return l'image de la pièce.
     */
    public Image getImagePiece() {
        return image;
    }

    /**
     * Cette méthode retourne les mouvements valides de la pièce.
     * @param board l'échiquier.
     * @return un tableau des mouvements valides.
     */
    public abstract int[][] validMoves(ChessPlate board);

    /**
     * Cette méthode retourne la couleur de la pièce.
     * @return la couleur de la pièce.
     */
    public int getColor() {
        return couleur;
    }

    /**
     * Cette méthode vérifie si deux pièces sont de la même couleur.
     * @param piece la pièce à comparer.
     * @return vrai si les deux pièces sont de la même couleur, faux sinon.
     */
    public boolean isSameColor(Piece piece) {
        return this.getColor() == piece.getColor();
    }

    /**
     * Cette méthode retourne la position x de la pièce.
     * @return la position x de la pièce.
     */
    public int getX() {
        return x;
    }

    /**
     * Cette méthode retourne la position y de la pièce.
     * @return la position y de la pièce.
     */
    public int getY() {
        return y;
    }

    /**
     * Cette méthode retourne la couleur de la pièce en chaîne de caractères.
     * @return la couleur de la pièce.
     */
    public String getCouleurString() {
        return name;
    }

    /**
     * Cette méthode définit la position x de la pièce.
     * @param x la nouvelle position x de la pièce.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Cette méthode définit la position y de la pièce.
     * @param y la nouvelle position y de la pièce.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Cette méthode vérifie si un mouvement est valide pour la pièce.
     * @param x la position x du mouvement.
     * @param y la position y du mouvement.
     * @return vrai si le mouvement est valide, faux sinon.
     */
    public abstract boolean isValidMove(int x, int y);

    public int getPieceColor() {
        if (couleur == 0) {
            pieceColor = 0;
            return pieceColor;
        } else {
            pieceColor = 1;
            return pieceColor;
        }
    }
}


