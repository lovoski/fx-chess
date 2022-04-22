package org.project.chess.utils;

import java.util.Objects;

public class BoardPosition {

    private int xPos,yPos;
    int PieceOnType = 0;

    public BoardPosition() {}

    public BoardPosition(int xPos, int yPos)  {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public BoardPosition(int xPos,int yPos,int PieceOnType) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.PieceOnType = PieceOnType;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPosition that = (BoardPosition) o;
        return xPos == that.xPos && yPos == that.yPos && PieceOnType == that.PieceOnType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPos, yPos, PieceOnType);
    }
}
