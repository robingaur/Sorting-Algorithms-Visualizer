package GUI;

import UtilityClasses.ConstKeys;
import UtilityClasses.MenuItemCustomException;
import UtilityClasses.Rectangle;
import algorithms.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;

class MenuItemListener implements ActionListener, KeyListener {

    private MainCanvas canvas;
    private AbstractAlgorithms abstractAlgorithms;
    private Rectangle rectangle;

    public MenuItemListener(MainCanvas canvas) {
        this.canvas = canvas;
    }

    private void initializeRectangle() {
        this.rectangle = new Rectangle(this.canvas.getGraphics(), this.canvas.getWidth(),
                this.canvas.getHeight(), this.canvas.getDataSize());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        try {
            switch (action) {
                case ConstKeys.SHUFFLE_DATA_MENU_ITEM:
                    this.shuffleDataMenuItem();
                    break;
                case ConstKeys.START_PAUSE_MENU_ITEM:
                    this.startPauseMenuItem();
                    break;
                case ConstKeys.BUBBLE_SORT_MENU_ITEM:
                    this.sortingCheck();
                    this.bubbleSortMenuItem();
                    break;
                case ConstKeys.INSERTION_SORT_MENU_ITEM:
                    this.sortingCheck();
                    this.insertionSortMenuItem();
                    break;
                case ConstKeys.SELECTION_SORT_MENU_ITEM:
                    this.sortingCheck();
                    this.selectionSortMenuItem();
                    break;
                case ConstKeys.QUICK_SORT_MENU_ITEM:
                    this.sortingCheck();
                    this.quickSortMenuItem();
                    break;
                case ConstKeys.MERGE_SORT_MENU_ITEM:
                    this.sortingCheck();
                    this.mergeSortMenuItem();
                    break;
                case ConstKeys.HEAP_SORT_MENU_ITEM:
                    this.sortingCheck();
                    this.heapSortMenuItem();
                    break;
                case ConstKeys.HELP_MENU_ITEM:
                    this.helpMenuItem();
                    break;
                default:
                    this.invalidAction();
                    break;
            }
        } catch (MenuItemCustomException ex) {
        }
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


    private void shuffleDataMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                JOptionPane.showMessageDialog(this.canvas.getFrame(), "Sorting is not Completed", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Collections.shuffle(canvas.getList());
        this.canvas.setListSorted(false);
        this.canvas.repaint();
    }

    private void startPauseMenuItem() {
    }

    private void sortingCheck() throws MenuItemCustomException {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                JOptionPane.showMessageDialog(this.canvas.getFrame(), "Sorting is not Completed.", "Error!",
                        JOptionPane.ERROR_MESSAGE);
                throw new MenuItemCustomException("Sorting is not Completed");
            }
        }

        if (this.canvas.isListSorted()) {
            JOptionPane.showMessageDialog(this.canvas.getFrame(), "Already Sorted!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            throw new MenuItemCustomException("Already Sorted!");
        }
    }

    private void bubbleSortMenuItem() {
        this.initializeRectangle();
        this.abstractAlgorithms = new BubbleSort(this.canvas.getList(), this.rectangle);
        Thread thread = new Thread(abstractAlgorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void insertionSortMenuItem() {
        this.initializeRectangle();
        this.abstractAlgorithms = new InsertionSort(this.canvas.getList(), this.rectangle);
        Thread thread = new Thread(abstractAlgorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void selectionSortMenuItem() {
        this.initializeRectangle();
        this.abstractAlgorithms = new SelectionSort(this.canvas.getList(), this.rectangle);
        Thread thread = new Thread(abstractAlgorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void quickSortMenuItem() {
        this.initializeRectangle();
        this.abstractAlgorithms = new QuickSort(this.canvas.getList(), this.rectangle);
        Thread thread = new Thread(abstractAlgorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void mergeSortMenuItem() {
        this.initializeRectangle();
        this.abstractAlgorithms = new MergeSort(this.canvas.getList(), this.rectangle);
        Thread thread = new Thread(abstractAlgorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void heapSortMenuItem() {
        this.initializeRectangle();
        this.abstractAlgorithms = new HeapSort(this.canvas.getList(), this.rectangle);
        Thread thread = new Thread(abstractAlgorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void helpMenuItem() {
    }

    private void invalidAction() {
    }
}