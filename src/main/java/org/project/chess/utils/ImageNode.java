package org.project.chess.utils;

import javafx.scene.image.ImageView;

public class ImageNode {

    public ImageView image;
    public double xPos,yPos;
    int type;
    public boolean showing = true;

    public ImageNode(double xPos,double yPos) {
        this.xPos = xPos;;
        this.yPos = yPos;
    }

    public ImageNode(ImageView image,int type) {
        this.image = image;
        this.xPos = image.getLayoutX();
        this.yPos = image.getLayoutY();
        this.type = type;
    }

    public boolean isSame(ImageNode node) {
        return Double.compare(this.xPos,node.xPos)==0 && Double.compare(this.yPos,node.yPos)==0;
    }
}
