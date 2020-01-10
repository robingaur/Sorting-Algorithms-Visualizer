package GUI;

import UtilityClasses.ConstKeys;
import UtilityClasses.Rectangle;
import algorithms.*;

import javax.swing.*;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;

class MenuItemListener implements ActionListener, KeyListener {

    private MainCanvas canvas;

    public void MenuKeyListener(MainCanvas canvas) {
        this.canvas = canvas;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case ConstKeys.SHUFFLE_DATA_MENU_ITEM:
                this.shuffleDataMenuItem();
                break;
            case ConstKeys.START_PAUSE_MENU_ITEM:
                this.startPauseMenuItem();
                break;
            case ConstKeys.BUBBLE_SORT_MENU_ITEM:
                if (this.sortingCheck()) {
                    this.bubbleSortMenuItem();
                }
                break;
            case ConstKeys.INSERTION_SORT_MENU_ITEM:
                this.insertionSortMenuItem();
                break;
            case ConstKeys.SELECTION_SORT_MENU_ITEM:
                this.selectionSortMenuItem();
                break;
            case ConstKeys.QUICK_SORT_MENU_ITEM:
                this.quickSortMenuItem();
                break;
            case ConstKeys.MERGE_SORT_MENU_ITEM:
                this.mergeSortMenuItem();
                break;
            case ConstKeys.HEAP_SORT_MENU_ITEM:
                this.heapSortMenuItem();
                break;
            case ConstKeys.HELP_MENU_ITEM:
                this.helpMenuItem();
                break;
            default:
                this.invalidAction();
                break;
        }
    }

    private void shuffleDataMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
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
