package UtilityClasses;

import java.awt.*;

public interface RectangleInterface {

    /**
     * Draw a rectangle at given index and height of given color.
     *
     * @param index
     * @param height
     * @param color
     */
    void drawAtIndex(int index, int height, Color color);

    /**
     * delete a rectangle at given index and height.
     *
     * @param index
     * @param height
     */
    void removeAtIndex(int index, int height);
}
