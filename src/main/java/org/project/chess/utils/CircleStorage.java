package org.project.chess.utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class CircleStorage {

    public Circle circle;
    public Color oriColor;
    public double xPos,yPos;

    public CircleStorage(double xPos,double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public CircleStorage(Circle circle) {
        this.circle = circle;
        this.oriColor = (Color) circle.getFill();
        this.xPos = circle.getLayoutX();
        this.yPos = circle.getLayoutY();
    }

    public boolean isSame(CircleStorage cs) {
        //System.out.println(cs);
        int valX = (int)((xPos-ChessPieces.BOARD_X_MIN)/ChessPieces.WALK_LENGTH);
        int valY = (int)((yPos-ChessPieces.BOARD_Y_MIN)/ChessPieces.WALK_LENGTH);
        return valX==(int)(cs.xPos/ChessPieces.WALK_LENGTH) && valY==(int)(cs.yPos/ChessPieces.WALK_LENGTH);
    }
}
