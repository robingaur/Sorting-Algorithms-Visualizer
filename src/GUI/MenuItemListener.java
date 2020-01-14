package GUI;

import UtilityClasses.ConstKeys;
import UtilityClasses.MenuItemCustomException;
import UtilityClasses.Rectangle;
import UtilityClasses.RectangleInterface;
import algorithms.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;

class MenuItemListener implements ActionListener, KeyListener, ChangeListener {

    private MainCanvasInterface canvas;
    private AlgorithmsInterface algorithms;
    private RectangleInterface rectangle;
    private double animationDelay;

    public MenuItemListener(MainCanvasInterface canvas) {
        this.canvas = canvas;
        this.animationDelay = 10;
    }

    private void initializeRectangle() {
        this.rectangle = new Rectangle(this.canvas);
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
                case ConstKeys.FINISH_EXECUTION_MENU_ITEM:
                    this.finishExecutionMenuItem();
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
            case KeyEvent.VK_S:
                this.shuffleDataMenuItem();
                break;
            case KeyEvent.VK_F:
                this.finishExecutionMenuItem();
                break;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if (slider.getValueIsAdjusting()) {
            int sliderValue = slider.getValue();
            if (sliderValue >= 50) {
                this.animationDelay = 20 - 0.2 * sliderValue;
            } else {
                this.animationDelay = 60 - sliderValue;
            }

            if (this.algorithms != null && this.algorithms.getAnimationDelay() != Double.MAX_VALUE) {
                this.algorithms.setAnimationDelay(this.animationDelay);
            }
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

        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                if (this.algorithms.getAnimationDelay() == Double.MAX_VALUE) {
                    this.algorithms.setAnimationDelay(this.animationDelay);
                    thread.interrupt();
                } else {
                    this.algorithms.setAnimationDelay(Double.MAX_VALUE);
                }
            }
        }

    }

    private void finishExecutionMenuItem() {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getName().equals(ConstKeys.SORTING_THREAD) && thread.isAlive()) {
                this.algorithms.setAnimationDelay(0);
                return;
            }
        }

        JOptionPane.showMessageDialog(this.canvas.getFrame(), "No Sorting Algorithm is running.", "Error!",
                JOptionPane.ERROR_MESSAGE);
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
        this.algorithms = new BubbleSort(this.canvas.getList(), this.rectangle);
        this.algorithms.setAnimationDelay(this.animationDelay);
        Thread thread = new Thread(algorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void insertionSortMenuItem() {
        this.initializeRectangle();
        this.algorithms = new InsertionSort(this.canvas.getList(), this.rectangle);
        this.algorithms.setAnimationDelay(this.animationDelay);
        Thread thread = new Thread(algorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void selectionSortMenuItem() {
        this.initializeRectangle();
        this.algorithms = new SelectionSort(this.canvas.getList(), this.rectangle);
        this.algorithms.setAnimationDelay(this.animationDelay);
        Thread thread = new Thread(algorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void quickSortMenuItem() {
        this.initializeRectangle();
        this.algorithms = new QuickSort(this.canvas.getList(), this.rectangle);
        this.algorithms.setAnimationDelay(this.animationDelay);
        Thread thread = new Thread(algorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void mergeSortMenuItem() {
        this.initializeRectangle();
        this.algorithms = new MergeSort(this.canvas.getList(), this.rectangle);
        this.algorithms.setAnimationDelay(this.animationDelay);
        Thread thread = new Thread(algorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void heapSortMenuItem() {
        this.initializeRectangle();
        this.algorithms = new HeapSort(this.canvas.getList(), this.rectangle);
        this.algorithms.setAnimationDelay(this.animationDelay);
        Thread thread = new Thread(algorithms, ConstKeys.SORTING_THREAD);
        this.canvas.setListSorted(true);
        thread.start();
    }

    private void helpMenuItem() {
    }

    private void invalidAction() {
    }
}