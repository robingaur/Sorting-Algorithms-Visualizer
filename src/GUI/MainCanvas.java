package GUI;

import UtilityClasses.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCanvas extends JPanel implements MainCanvasInterface {

    private JFrame frame;
    private final int DATA_SIZE;
    private List<Number> list;
    private boolean isListSorted;

    public MainCanvas() {
        try {
            EventQueue.invokeAndWait(new EventQueueThread(this));
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

        this.setFocusable(true);

        this.DATA_SIZE = 100;
        this.list = new ArrayList<>(this.DATA_SIZE);
        for (int i = 0; i < this.DATA_SIZE; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        this.isListSorted = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Rectangle rectangle = new Rectangle(g, super.getWidth(), super.getHeight(), this.DATA_SIZE);

        // White Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, super.getWidth(), super.getHeight());
        // Black Border
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, super.getWidth(), super.getHeight());

        for (int i = 0; i < this.list.size(); i++) {
            rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.GREEN);
        }
    }

    @Override
    public JFrame getFrame() {
        return this.frame;
    }

    @Override
    public List<Number> getList() {
        return this.list;
    }

    @Override
    public void setListSorted(boolean listsorted) {
        this.isListSorted = listsorted;
    }

    @Override
    public boolean isListSorted() {
        return this.isListSorted;
    }

    @Override
    public int getDataSize() {
        return this.DATA_SIZE;
    }
}
