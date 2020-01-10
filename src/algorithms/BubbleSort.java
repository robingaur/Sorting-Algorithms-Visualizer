package algorithms;

import UtilityClasses.Rectangle;

import java.util.List;

public class BubbleSort extends AbstractAlgorithms implements Runnable {

    public BubbleSort(List<Number> list, Rectangle rectangle) {
        super(list, rectangle);
    }

    @Override
    void sort() {
        for (int i = 0; i < super.list.size(); i++) {
            for (int j = 0; j < super.list.size() - i - 1; j++) {
                if (super.list.get(j).intValue() > super.list.get(j + 1).intValue()) {
                    super.swap(j, j + 1);
                }
            }
        }
    }
}
