package GUI;

import javax.swing.*;
import java.awt.*;

class EventQueueThread implements Runnable {

    private JFrame frame;
    private MainCanvas mainCanvas;

    public EventQueueThread(JFrame frame, MainCanvas mainCanvas) {
        this.frame = frame;
        this.mainCanvas = mainCanvas;
    }


    @Override
    public void run() {
        try {
            this.frame = new JFrame("Sorting Algorithms Visualizer");
            this.frame.setVisible(true);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setResizable(false);
            this.frame.setBackground(Color.WHITE);
            this.frame.add(mainCanvas);
//            this.frame.setJMenuBar(setMenuBar());

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.frame.setSize(screenSize);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
