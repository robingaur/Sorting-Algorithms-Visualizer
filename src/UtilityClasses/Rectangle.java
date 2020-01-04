package UtilityClasses;

import java.awt.*;

public class Rectangle {

    Graphics g;
    int canvasWidth;
    int canvasHeight;
    int dataLength;

    public Rectangle(Graphics g, int canvasWidth, int canvasHeight, int dataLength) {
        this.g = g;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.dataLength = dataLength;
    }

    public void drawAtIndex(int index, int height, Color color) {
        int rectangleWidth = this.canvasWidth / (this.dataLength + 2);
        int x = rectangleWidth * (index + 1);
        int y = this.canvasHeight / (this.dataLength + 2) * (this.dataLength - height) + 50;
        int rectangleHeight = this.canvasHeight / (this.dataLength + 2) * (height + 1);

        this.g.setColor(color);
        this.g.fillRect(x, y, rectangleWidth, rectangleHeight);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, rectangleWidth, rectangleHeight);
    }

    public void removeAtIndex(int index, int height) {

        int rectangleWidth = this.canvasWidth / (this.dataLength + 2);
        int x = rectangleWidth * (index + 1);
        int y = this.canvasHeight / (this.dataLength + 2) * (this.dataLength - height) + 50;
        int rectangleHeight = this.canvasHeight / (this.dataLength + 2) * (height + 1);

        this.g.setColor(Color.WHITE);
        this.g.fillRect(x, y, rectangleWidth, rectangleHeight);

        g.setColor(Color.WHITE);
        g.drawRect(x, y, rectangleWidth, rectangleHeight);
    }
}
