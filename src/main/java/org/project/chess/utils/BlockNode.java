package org.project.chess.utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BlockNode {

    public Rectangle block;
    public Color oriColor;
    public int type;
    public double xPos, yPos;
    public BlockNode next;

    public BlockNode(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public BlockNode(Rectangle block, int type) {
        this.block = block;
        this.oriColor = (Color) block.getFill();
        this.xPos = block.getLayoutX();
        this.yPos = block.getLayoutY();
        this.type = type;
        //System.out.println(xPos+" "+yPos);
    }

    public boolean isSame(BlockNode node) {
        return (Double.compare(node.xPos, xPos) == 0) && (Double.compare(node.yPos, yPos) == 0);
    }

    public int hashCode() {
        return (int) (xPos + yPos * 2);
    }
}
