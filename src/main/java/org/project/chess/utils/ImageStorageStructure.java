package org.project.chess.utils;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class ImageStorageStructure {

    ArrayList<ImageNode> store = new ArrayList<>(32);

    public ImageStorageStructure() {}

    public void fillInAllImage(ImageNode[][] image) {
        for (ImageNode[] imageViews : image) {
            store.addAll(Arrays.asList(imageViews));
        }
    }

    public void findImageByPosition(double xPos,double yPos,boolean showing) {
        ImageNode newNode = new ImageNode(xPos,yPos);
        for (ImageNode imageNode : store) {
            if (imageNode.isSame(newNode)) {
                imageNode.image.setVisible(showing);
            }
        }
    }

    public void findImageAndMove(double xPos,double yPos,double targetX,double targetY) {
        ImageNode newNode = new ImageNode(xPos,yPos);
        for (ImageNode imageNode : store) {
            if (imageNode.isSame(newNode)) {
                imageNode.image.setLayoutX(targetX);
                imageNode.image.setLayoutY(targetY);
                imageNode.xPos = targetX;
                imageNode.yPos = targetY;
            }
        }
    }

    public void findImageAndMove(double xPos,double yPos,int type) {
        if (type==0) return;
        for (ImageNode imageNode : store) {
            if (imageNode.type == type) {
                imageNode.image.setVisible(true);
                imageNode.image.setLayoutX(xPos);
                imageNode.image.setLayoutY(yPos);
                return;
            }
        }
    }

    public void  repaintChessBoard(int[] store_type) {
        for (ImageNode imageNode : store) {
            imageNode.image.setVisible(false);
        }
        for (int i = 0;i<store_type.length;i++) {
            double xPos = (i%8)*ChessPieces.WALK_LENGTH+ChessPieces.BOARD_X_MIN;
            double yPos = ((int)((i-i%8)/8))*ChessPieces.WALK_LENGTH+ChessPieces.BOARD_Y_MIN;
            findImageAndMove(xPos,yPos,store_type[i]);
        }
    }
}
