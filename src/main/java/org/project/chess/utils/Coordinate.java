package org.project.chess.utils;

public class Coordinate {
    private double xPos,yPos;
    private boolean isPath;
    public Coordinate(double xPos,double yPos,boolean isPath) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isPath = isPath;
    }
    public double getXPos() {
        return xPos;
    }
    public double getYPos() {
        return yPos;
    }
    public boolean getIsPath() {
        return isPath;
    }
    public void setXPos(double xPos) {
        this.xPos = xPos;
    }
    public void setYPos(double yPos) {
        this.yPos = yPos;
    }
    public void setIsPath(boolean isPath) {
        this.isPath = isPath;
    }
}
