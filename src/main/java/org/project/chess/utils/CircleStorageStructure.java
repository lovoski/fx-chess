package org.project.chess.utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class CircleStorageStructure {

    Color target,path;

    ArrayList<CircleStorage> store = new ArrayList<>(64);

    public CircleStorageStructure() {
        target = Color.valueOf("21981F");
        path = Color.valueOf("D11A3B");
    }

    public void fillInAllStore(Circle[][] circles) {
        for (Circle[] circles1 : circles) {
            for (Circle circle : circles1) {
                store.add(new CircleStorage(circle));
            }
        }
    }

    public void findAndMarkAndShow(Coordinate c,boolean changeColor) {
        CircleStorage tempCS = new CircleStorage(c.getXPos(), c.getYPos());
        for (CircleStorage circleStorage : store) {
            if (circleStorage.isSame(tempCS)) {
                //System.out.println(changeColor);
                circleStorage.circle.setVisible(changeColor);
                if (changeColor) {
                    if (c.getIsPath()) {
                        circleStorage.circle.setFill(path);
                        //System.out.println(circleStorage.circle);
                    } else circleStorage.circle.setFill(target);

                } else {
                    circleStorage.circle.setFill(circleStorage.oriColor);
                }
                return;
            }
        }
    }
}
