package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class InsertionSort extends AbstractAlgorithms {

    public InsertionSort(List<Integer> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {
        int j;
        for (int i = 1; i < super.list.size(); i++) {
            j = i;
            while (j > 0 && super.list.get(j - 1) > super.list.get(j)) {
                super.swapWithAnimation(j, j - 1);
                j--;
            }
        }
    }
}
