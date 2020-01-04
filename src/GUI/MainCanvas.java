package GUI;

import UtilityClasses.Rectangle;
import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.QuickSort;
import algorithms.SelectionSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCanvas extends JPanel {

    private static JFrame frame;
    private final int DATA_SIZE;
    private List<Number> list;
    private boolean isSorted;

    public MainCanvas() {
        try {
            EventQueue.invokeAndWait(new EventQueueThread());
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

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
        MenuItemListener menuItemListener = new MenuItemListener();

        JMenu menuMenu = new JMenu("Menu");
        JMenu algorithmMenu = new JMenu("Algorithms");
        JMenu helpMenu = new JMenu("Help");

        // MenuMenu
        JMenuItem shuffleData = new JMenuItem("Shuffle Data");
        shuffleData.setActionCommand("SHUFFLE_DATA_MENU_ITEM");
        shuffleData.addActionListener(menuItemListener);
        menuMenu.add(shuffleData);

        menuBar.add(menuMenu);

        // Algorithm Menu
        JMenuItem bubbleSort = new JMenuItem("Bubble Sort");
        bubbleSort.setActionCommand("BUBBLE_SORT_MENU_ITEM");
        bubbleSort.addActionListener(menuItemListener);
        algorithmMenu.add(bubbleSort);

        JMenuItem insertionSort = new JMenuItem("Insertion Sort");
        insertionSort.setActionCommand("INSERTION_SORT_MENU_ITEM");
        insertionSort.addActionListener(menuItemListener);
        algorithmMenu.add(insertionSort);

        JMenuItem selectionSort = new JMenuItem("Selection Sort");
        selectionSort.setActionCommand("SELECTION_SORT_MENU_ITEM");
        selectionSort.addActionListener(menuItemListener);
        algorithmMenu.add(selectionSort);

        JMenuItem quickSort = new JMenuItem("Quick Sort");
        quickSort.setActionCommand("QUICK_SORT_MENU_ITEM");
        quickSort.addActionListener(menuItemListener);
        algorithmMenu.add(quickSort);

        JMenuItem mergeSort = new JMenuItem("Merge Sort");
        mergeSort.setActionCommand("MERGE_SORT_MENU_ITEM");
        mergeSort.addActionListener(menuItemListener);
        algorithmMenu.add(mergeSort);

        JMenuItem heapSort = new JMenuItem("Heap Sort");
        heapSort.setActionCommand("HEAP_SORT_MENU_ITEM");
        heapSort.addActionListener(menuItemListener);
        algorithmMenu.add(heapSort);

        menuBar.add(algorithmMenu);

        // Help Menu
        JMenuItem help = new JMenuItem("Help");
        help.setActionCommand("HELP_MENU_ITEM");
        help.addActionListener(menuItemListener);
        helpMenu.add(help);

        menuBar.add(helpMenu);

        return menuBar;
    }

    private class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch (action) {
                case "SHUFFLE_DATA_MENU_ITEM":
                    this.shuffleDataMenuItem();
                    break;
                case "BUBBLE_SORT_MENU_ITEM":
                    this.bubbleSortMenuItem();
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
            Collections.shuffle(list);
            isSorted = false;
            repaint();
        }

        private void bubbleSortMenuItem() {
            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(MainCanvas.this.frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);
            new BubbleSort(MainCanvas.this.list).sort(rectangle);
            MainCanvas.this.isSorted = true;
        }

        private void insertionSortMenuItem() {
            if (MainCanvas.this.isSorted) {
                JOptionPane.showMessageDialog(MainCanvas.this.frame, "Already Sorted", "Error!",
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
                JOptionPane.showMessageDialog(MainCanvas.this.frame, "Already Sorted", "Error!",
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
                JOptionPane.showMessageDialog(MainCanvas.this.frame, "Already Sorted", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Rectangle rectangle = new Rectangle(MainCanvas.this.getGraphics(), MainCanvas.super.getWidth(),
                    MainCanvas.super.getHeight(), MainCanvas.this.DATA_SIZE);
            new QuickSort(MainCanvas.this.list).sort(rectangle);
            MainCanvas.this.isSorted = true;
        }

        private void mergeSortMenuItem() {
            isSorted = true;
        }

        private void heapSortMenuItem() {
            isSorted = true;
        }

        private void helpMenuItem() {
        }

        private void invalidAction() {
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
