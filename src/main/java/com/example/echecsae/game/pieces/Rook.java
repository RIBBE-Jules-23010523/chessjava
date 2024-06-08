package com.example.echecsae.game.pieces;

import com.example.echecsae.game.ChessPlate;

/**
 * Cette classe représente une tour dans le jeu d'échecs.
 */
public class Rook extends Piece {

    /**
     * Constructeur de la classe Rook.
     * @param name le nom de la pièce.
     * @param color la couleur de la pièce.
     * @param pieceColor le code couleur de la pièce.
     * @param locationX la position x de la pièce.
     * @param locationY la position y de la pièce.
     */
    public Rook(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    /**
     * Cette méthode retourne les mouvements valides de la tour.
     * @param board l'échiquier.
     * @return un tableau des mouvements valides.
     * La tour peut se déplacer horizontalement et verticalement.
     */
    public int[][] validMoves (ChessPlate board) {
        int[][] moves = new int[64][2];
        int i = 0;
        int[] directions = {1, -1};
        for (int dir : directions) {
            int x = getX();
            while (true) {
                x += dir;
                if (x < 0 || x >= 8)
                    break;
                if (board.getPiece(x, getY()) == null) {
                    moves[i][0] = x;
                    moves[i][1] = getY();
                    i++;
                } else {
                    if (!isSameColor(board.getPiece(x, getY()))) {
                        moves[i][0] = x;
                        moves[i][1] = getY();
                        i++;
                    }
                    break;
                }
            }
        }
        for (int dir : directions) {
            int y = getY();
            while (true) {
                y += dir;
                if (y < 0 || y >= 8) break; // Sortir de l'échiquier
                if (board.getPiece(getX(), y) == null) {
                    moves[i][0] = getX();
                    moves[i][1] = y;
                    i++;
                } else {
                    if (!isSameColor(board.getPiece(getX(), y))) {
                        moves[i][0] = getX();
                        moves[i][1] = y;
                        i++;
                    }
                    break;
                }
            }
        }
        int[][] validMoves = new int[i][2];
        System.arraycopy(moves, 0, validMoves, 0, i);
        return validMoves;
    }

    /**
     * Cette méthode vérifie si un mouvement est valide pour la tour.
     * @param x la position x du mouvement.
     * @param y la position y du mouvement.
     * @return vrai si le mouvement est valide, faux sinon.
     */
    @Override
    public boolean isValidMove(int x, int y) {
        return false;
    }

    /**
     * Cette méthode retourne la représentation en chaîne de caractères de la tour.
     * @return la représentation en chaîne de caractères de la tour.
     */
    @Override
    public String toString() {
        return "Rook";
    }

}
