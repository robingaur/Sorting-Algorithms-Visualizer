package UtilityClasses;

import GUI.MainCanvasInterface;

import java.awt.*;

public class Rectangle implements RectangleInterface {

    Graphics g;
    int canvasWidth;
    int canvasHeight;
    int dataLength;

    public Rectangle(MainCanvasInterface canvas) {
        this.g = canvas.getGraphics();
        this.canvasWidth = canvas.getWidth();
        this.canvasHeight = canvas.getHeight();
        this.dataLength = canvas.getDataSize();
    }

    @Override
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

    @Override
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
