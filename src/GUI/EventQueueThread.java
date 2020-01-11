package GUI;

import UtilityClasses.ConstKeys;

import javax.swing.*;
import java.awt.*;

class EventQueueThread implements Runnable {

    private MainCanvas mainCanvas;
    private JFrame frame;
    private MenuItemListener menuItemListener;

    public EventQueueThread(MainCanvas mainCanvas, JFrame frame) {
        this.mainCanvas = mainCanvas;
        this.frame = frame;
        this.menuItemListener = new MenuItemListener(mainCanvas);
    }

    @Override
    public void run() {
        try {
            this.frame = new JFrame("Sorting Algorithms Visualizer");
            this.frame.setVisible(true);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setResizable(false);
            this.frame.setBackground(Color.WHITE);
            this.frame.add(this.mainCanvas);
            this.frame.setJMenuBar(this.setMenuBar());
            this.mainCanvas.addKeyListener(this.menuItemListener);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.frame.setSize(screenSize);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuMenu = new JMenu("Menu");
        JMenu algorithmMenu = new JMenu("Algorithms");
        JMenu speedMenu = new JMenu("Animation Speed");
        JMenu helpMenu = new JMenu("Help");

        {
            // MenuMenu
            JMenuItem shuffleData = new JMenuItem("Shuffle Data");
            shuffleData.setActionCommand(ConstKeys.SHUFFLE_DATA_MENU_ITEM);
            shuffleData.addActionListener(this.menuItemListener);
            menuMenu.add(shuffleData);

            JMenuItem start_pause = new JMenuItem("Start/Pause");
            start_pause.setActionCommand(ConstKeys.START_PAUSE_MENU_ITEM);
            start_pause.addActionListener(this.menuItemListener);
            menuMenu.add(start_pause);

            JMenuItem finishExecution = new JMenuItem("Finish Execution");
            finishExecution.setActionCommand(ConstKeys.FINISH_EXECUTION_MENU_ITEM);
            finishExecution.addActionListener(this.menuItemListener);
            menuMenu.add(finishExecution);

            menuBar.add(menuMenu);
        }

        {
            // Algorithm Menu
            JMenuItem bubbleSort = new JMenuItem("Bubble Sort");
            bubbleSort.setActionCommand(ConstKeys.BUBBLE_SORT_MENU_ITEM);
            bubbleSort.addActionListener(this.menuItemListener);
            algorithmMenu.add(bubbleSort);

            JMenuItem insertionSort = new JMenuItem("Insertion Sort");
            insertionSort.setActionCommand(ConstKeys.INSERTION_SORT_MENU_ITEM);
            insertionSort.addActionListener(this.menuItemListener);
            algorithmMenu.add(insertionSort);

            JMenuItem selectionSort = new JMenuItem("Selection Sort");
            selectionSort.setActionCommand(ConstKeys.SELECTION_SORT_MENU_ITEM);
            selectionSort.addActionListener(this.menuItemListener);
            algorithmMenu.add(selectionSort);

            JMenuItem quickSort = new JMenuItem("Quick Sort");
            quickSort.setActionCommand(ConstKeys.QUICK_SORT_MENU_ITEM);
            quickSort.addActionListener(this.menuItemListener);
            algorithmMenu.add(quickSort);

            JMenuItem mergeSort = new JMenuItem("Merge Sort");
            mergeSort.setActionCommand(ConstKeys.MERGE_SORT_MENU_ITEM);
            mergeSort.addActionListener(this.menuItemListener);
            algorithmMenu.add(mergeSort);

            JMenuItem heapSort = new JMenuItem("Heap Sort");
            heapSort.setActionCommand(ConstKeys.HEAP_SORT_MENU_ITEM);
            heapSort.addActionListener(this.menuItemListener);
            algorithmMenu.add(heapSort);

            menuBar.add(algorithmMenu);
        }

        {
            // Speed Menu
            JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 99, 90);
            speedSlider.setMajorTickSpacing(20);
            speedSlider.setMinorTickSpacing(5);
            speedSlider.setPaintTicks(true);
            speedSlider.setPaintLabels(true);
            speedMenu.add(speedSlider);
            menuBar.add(speedMenu);
        }
        {
            // Speed Menu
//            ButtonGroup speedGroup = new ButtonGroup();
//
//            JMenuItem verySlowSpeed = new JRadioButtonMenuItem("Very Slow");
//            verySlowSpeed.setActionCommand(ConstKeys.VERY_SLOW_SPEED_MENU_ITEM);
//            verySlowSpeed.addActionListener(this.menuItemListener);
//            speedMenu.add(verySlowSpeed);
//            speedGroup.add(verySlowSpeed);
//
//            JMenuItem slowSpeed = new JRadioButtonMenuItem("Very Slow");
//            slowSpeed.setActionCommand(ConstKeys.SLOW_SPEED_MENU_ITEM);
//            slowSpeed.addActionListener(this.menuItemListener);
//            speedMenu.add(slowSpeed);
//            speedGroup.add(slowSpeed);
//
//            JMenuItem normalSpeed = new JRadioButtonMenuItem("Normal");
//            normalSpeed.setActionCommand(ConstKeys.NORMAL_SPEED_MENU_ITEM);
//            normalSpeed.addActionListener(this.menuItemListener);
//            speedMenu.add(normalSpeed);
//            speedGroup.add(normalSpeed);
//
//            JMenuItem fastSpeed = new JRadioButtonMenuItem("Fast");
//            fastSpeed.setActionCommand(ConstKeys.FAST_SPEED_MENU_ITEM);
//            fastSpeed.addActionListener(this.menuItemListener);
//            speedMenu.add(fastSpeed);
//            speedGroup.add(fastSpeed);
//
//            JMenuItem veryFastSpeed = new JRadioButtonMenuItem("Very Fast");
//            veryFastSpeed.setActionCommand(ConstKeys.VERY_FAST_SPEED_MENU_ITEM);
//            veryFastSpeed.addActionListener(this.menuItemListener);
//            speedMenu.add(veryFastSpeed);
//            speedGroup.add(veryFastSpeed);
//
//            menuBar.add(speedMenu);
//            normalSpeed.setSelected(true);
        }

        {
            // Help Menu
            JMenuItem help = new JMenuItem("Help");
            help.setActionCommand(ConstKeys.HELP_MENU_ITEM);
            help.addActionListener(this.menuItemListener);
            helpMenu.add(help);

            menuBar.add(helpMenu);
        }

        return menuBar;
    }
}
