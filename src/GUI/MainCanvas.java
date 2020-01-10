package GUI;

import UtilityClasses.Rectangle;
import algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCanvas extends JPanel {

    private static JFrame frame;
    private final int DATA_SIZE;
    private List<Number> list;
    private boolean isSorted;
    private MenuItemListener menuItemListener;

    public MainCanvas() {
        try {
            EventQueue.invokeAndWait(new EventQueueThread());
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

        this.addKeyListener(this.menuItemListener);
        this.setFocusable(true);

        this.DATA_SIZE = 100;
        this.list = new ArrayList<>(this.DATA_SIZE);
        for (int i = 0; i < this.DATA_SIZE; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        this.isSorted = false;
    }

    @Override
    public void paintComponent(Graphics g) {
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

    private JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        this.menuItemListener = new MenuItemListener();

        JMenu menuMenu = new JMenu("Menu");
        JMenu algorithmMenu = new JMenu("Algorithms");
        JMenu helpMenu = new JMenu("Help");

        // MenuMenu
        JMenuItem shuffleData = new JMenuItem("Shuffle Data");
        shuffleData.setActionCommand("SHUFFLE_DATA_MENU_ITEM");
        shuffleData.addActionListener(this.menuItemListener);
        menuMenu.add(shuffleData);

        JMenuItem start_pause = new JMenuItem("Start/Pause");
        start_pause.setActionCommand("START_PAUSE_MENU_ITEM");
        start_pause.addActionListener(this.menuItemListener);
        menuMenu.add(start_pause);

        menuBar.add(menuMenu);

        // Algorithm Menu
        JMenuItem bubbleSort = new JMenuItem("Bubble Sort");
        bubbleSort.setActionCommand("BUBBLE_SORT_MENU_ITEM");
        bubbleSort.addActionListener(this.menuItemListener);
        algorithmMenu.add(bubbleSort);

        JMenuItem insertionSort = new JMenuItem("Insertion Sort");
        insertionSort.setActionCommand("INSERTION_SORT_MENU_ITEM");
        insertionSort.addActionListener(this.menuItemListener);
        algorithmMenu.add(insertionSort);

        JMenuItem selectionSort = new JMenuItem("Selection Sort");
        selectionSort.setActionCommand("SELECTION_SORT_MENU_ITEM");
        selectionSort.addActionListener(this.menuItemListener);
        algorithmMenu.add(selectionSort);

        JMenuItem quickSort = new JMenuItem("Quick Sort");
        quickSort.setActionCommand("QUICK_SORT_MENU_ITEM");
        quickSort.addActionListener(this.menuItemListener);
        algorithmMenu.add(quickSort);

        JMenuItem mergeSort = new JMenuItem("Merge Sort");
        mergeSort.setActionCommand("MERGE_SORT_MENU_ITEM");
        mergeSort.addActionListener(this.menuItemListener);
        algorithmMenu.add(mergeSort);

        JMenuItem heapSort = new JMenuItem("Heap Sort");
        heapSort.setActionCommand("HEAP_SORT_MENU_ITEM");
        heapSort.addActionListener(this.menuItemListener);
        algorithmMenu.add(heapSort);

        menuBar.add(algorithmMenu);

        // Help Menu
        JMenuItem help = new JMenuItem("Help");
        help.setActionCommand("HELP_MENU_ITEM");
        help.addActionListener(this.menuItemListener);
        helpMenu.add(help);

        menuBar.add(helpMenu);

        return menuBar;
    }

    private class MenuItemListener implements ActionListener, KeyListener {

        private AlgorithmsInterface algorithm;

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch (action) {
                case "SHUFFLE_DATA_MENU_ITEM":
                    this.shuffleDataMenuItem();
                    break;
                case "START_PAUSE_MENU_ITEM":
                    this.startPauseMenuItem();
                    break;
                case "BUBBLE_SORT_MENU_ITEM":
                    if (this.sortingCheck()) {
                        this.bubbleSortMenuItem();
                    }
                    break;
                case "INSERTION_SORT_MENU_ITEM":
                    this.insertionSortMenuItem();
                    break;
                case "SELECTION_SORT_MENU_ITEM":
                    this.selectionSortMenuItem();
                    break;
                case "QUICK_SORT_MENU_ITEM":
                    this.quickSortMenuItem();
                    break;
                case "MERGE_SORT_MENU_ITEM":
                    this.mergeSortMenuItem();
                    break;
                case "HEAP_SORT_MENU_ITEM":
                    this.heapSortMenuItem();
                    break;
                case "HELP_MENU_ITEM":
                    this.helpMenuItem();
                    break;
                default:
                    this.invalidAction();
                    break;
            }
        }

        private void shuffleDataMenuItem() {
            for (Thread th : Thread.getAllStackTraces().keySet()) {
                if (th.getName().equals("SORTING_THREAD") && th.isAlive()) {
                    JOptionPane.showMessageDialog(frame, "Sorting is not Completed", "Error!",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            Collections.shuffle(list);
            isSorted = false;
            repaint();
        }

        private void startPauseMenuItem() {
            if (this.algorithm.isSleep()) {
                this.algorithm.awake();
            } else {
                this.algorithm.sleep();
            }
        }

        private void bubbleSortMenuItem() {

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);

            BubbleSort bubbleSort = new BubbleSort(MainCanvas.this.list, rectangle);
            this.algorithm = bubbleSort;
            Thread thread = new Thread(bubbleSort, "SORTING_THREAD");
            MainCanvas.this.isSorted = true;
            thread.start();
        }

        private void insertionSortMenuItem() {
            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);
            new InsertionSort(MainCanvas.this.list).sort(rectangle);
            MainCanvas.this.isSorted = true;
        }

        private void selectionSortMenuItem() {
            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);
            new SelectionSort(MainCanvas.this.list).sort(rectangle);
            MainCanvas.this.isSorted = true;
        }

        private void quickSortMenuItem() {
            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);
            new QuickSort(MainCanvas.this.list).sort(rectangle);
            MainCanvas.this.isSorted = true;
        }

        private void mergeSortMenuItem() {
            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);
            new MergeSort(MainCanvas.this.list).sort(rectangle);
            MainCanvas.this.isSorted = true;
        }

        private void heapSortMenuItem() {
            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);
            new HeapSort(MainCanvas.this.list).sort(rectangle);
            MainCanvas.this.isSorted = true;
        }

        private boolean sortingCheck() {

            for (Thread th : Thread.getAllStackTraces().keySet()) {
                if (th.getName().equals("SORTING_THREAD") && th.isAlive()) {
                    JOptionPane.showMessageDialog(frame, "Sorting is not Completed", "Error!",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        }

        private void helpMenuItem() {
        }

        private void invalidAction() {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_SPACE:
                    this.startPauseMenuItem();
                    break;
            }
        }
    }

    private class EventQueueThread implements Runnable {

        @Override
        public void run() {
            try {
                frame = new JFrame("Sorting Algorithms Visualizer");
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setBackground(Color.WHITE);
                frame.add(MainCanvas.this);
                frame.setJMenuBar(setMenuBar());

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setSize(screenSize);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
