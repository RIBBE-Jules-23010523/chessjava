package com.example.echecsae.game.pieces;

import com.example.echecsae.game.ChessPlate;

/**
 * Cette classe représente une reine dans le jeu d'échecs.
 */
public class Queen extends Piece {

    /**
     * Constructeur de la classe Queen.
     * @param name le nom de la pièce.
     * @param color la couleur de la pièce.
     * @param pieceColor le code couleur de la pièce.
     * @param locationX la position x de la pièce.
     * @param locationY la position y de la pièce.
     */
    public Queen(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    /**
     * Cette méthode retourne les mouvements valides de la reine.
     * @param board l'échiquier.
     * @return un tableau des mouvements valides.
     * La reine peut se déplacer horizontalement, verticalement et diagonalement.
     */
    public int[][] validMoves(ChessPlate board) {
        int[][] moves = new int[64][2]; // La reine peut théoriquement avoir jusqu'à 64 mouvements possibles
        int i = 0;

        int[] directions = {1, -1, 0};


        for (int dirX : directions) {
            for (int dirY : directions) {
                if (dirX == 0 && dirY == 0)
                    continue;
                int x = getX();
                int y = getY();
                while (true) {
                    x += dirX;
                    y += dirY;
                    if (x < 0 || x >= 8 || y < 0 || y >= 8)
                        break;
                    if (board.getPiece(x, y) == null) {
                        moves[i][0] = x;
                        moves[i][1] = y;
                        i++;
                    } else {
                        if (!isSameColor(board.getPiece(x, y))) {
                            moves[i][0] = x;
                            moves[i][1] = y;
                            i++;
                        }
                        break;
                    }
                }
            }
        }
        int[][] validMoves = new int[i][2];
        System.arraycopy(moves, 0, validMoves, 0, i);
        return validMoves;
    }

    /**
     * Cette méthode vérifie si un mouvement est valide pour la reine.
     * @param x la position x du mouvement.
     * @param y la position y du mouvement.
     * @return vrai si le mouvement est valide, faux sinon.
     */
    @Override
    public boolean isValidMove(int x, int y) {
        return false;
    }

    /**
     * Cette méthode retourne la représentation en chaîne de caractères de la reine.
     * @return la représentation en chaîne de caractères de la reine.
     */
    @Override
    public String toString() {
        return "Queen";
    }
}
