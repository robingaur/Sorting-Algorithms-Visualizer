package algorithms;

import UtilityClasses.Rectangle;

import java.util.List;

public class InsertionSort extends AbstractAlgorithms {

    public InsertionSort(List<Number> list, Rectangle rectangle) {
        super(list, rectangle);
    }

    @Override
    void sort() {
        int j;
        for (int i = 1; i < super.list.size(); i++) {
            j = i;
            while (j > 0 && super.list.get(j - 1).intValue() > super.list.get(j).intValue()) {
                super.swapWithAnimation(j, j - 1);
                j--;
            }
        }
    }
}
