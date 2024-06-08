package com.example.echecsae.game.pieces;

import com.example.echecsae.game.ChessPlate;

/**
 * Cette classe représente un pion dans le jeu d'échecs.
 */
public class Pawn extends Piece {

    /**
     * Constructeur de la classe Pawn.
     * @param name le nom de la pièce.
     * @param color la couleur de la pièce.
     * @param pieceColor le code couleur de la pièce.
     * @param locationX la position x de la pièce.
     * @param locationY la position y de la pièce.
     */
    public Pawn(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    /**
     * Cette méthode retourne les mouvements valides du pion.
     * @param board l'échiquier.
     * @return un tableau des mouvements valides.
     * Les pions peuvent avancer d'une case, de deux cases depuis la position initiale, ou capturer en diagonale.
     */
    public int[][] validMoves(ChessPlate board) {
        int[][] moves = new int[4][2];
        int i = 0;

        // Déterminer la direction du mouvement: les pions blancs se déplacent vers le haut (-1), les noirs vers le bas (+1)
        int direction = (getPieceColor() == 0) ? -1 : 1;

        // Mouvement d'une case vers l'avant
        if (isWithinBounds(getX() + direction, getY()) && board.getPiece(getX() + direction, getY()) == null) {
            moves[i][0] = getX() + direction;
            moves[i][1] = getY();
            i++;

            // Mouvement de deux cases depuis la position initiale
            if ((getX() == 1 && direction == 1) || (getX() == 6 && direction == -1)) {
                if (board.getPiece(getX() + 2 * direction, getY()) == null) {
                    moves[i][0] = getX() + 2 * direction;
                    moves[i][1] = getY();
                    i++;
                }
            }
        }

        // Captures diagonales
        int[] diagonalMoves = {-1, 1};
        for (int dy : diagonalMoves) {
            int x = getX() + direction;
            int y = getY() + dy;
            if (isWithinBounds(x, y) && board.getPiece(x, y) != null && !isSameColor(board.getPiece(x, y))) {
                moves[i][0] = x;
                moves[i][1] = y;
                i++;
            }
        }

        int[][] validMoves = new int[i][2];
        System.arraycopy(moves, 0, validMoves, 0, i);
        return validMoves;
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    /**
     * Cette méthode vérifie si un mouvement est valide pour le pion.
     * @param x la position x du mouvement.
     * @param y la position y du mouvement.
     * @return vrai si le mouvement est valide, faux sinon.
     */
    @Override
    public boolean isValidMove(int x, int y) {
        // Implémenter cette méthode si nécessaire
        return false;
    }

    /**
     * Cette méthode retourne la représentation en chaîne de caractères du pion.
     * @return la représentation en chaîne de caractères du pion.
     */
    @Override
    public String toString() {
        return "Pawn";
    }
}
