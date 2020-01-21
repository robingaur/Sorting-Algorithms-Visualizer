package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public interface MainCanvasInterface {

    /**
     * @return Graphics Object
     */
    Graphics getGraphics();

    /**
     * @return the Width of panel
     */
    int getWidth();

    /**
     * @return the Height of JPanel
     */
    int getHeight();

    /**
     * This method will repaint the JFrame
     */
    void repaint();

    /**
     * @return the JFrame object
     */
    JFrame getFrame();

    /**
     * @return the List<Integer> Object of items
     */
    List<Integer> getList();

    /**
     * @param isListSorted is true, then method will set tha flag of isListSorted to true.
     * @param isListSorted is false, then method will set tha flag of isListSorted to false.
     */
    void setListSorted(boolean isListSorted);

    /**
     * @return is the list is sorted or not.
     */
    boolean isListSorted();

    /**
     * @return the data size
     */
    int getDataSize();
}
