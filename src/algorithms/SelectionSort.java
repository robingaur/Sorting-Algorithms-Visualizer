package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class SelectionSort extends AbstractAlgorithms {

    public SelectionSort(List<Integer> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {
        for (int i = 0; i < this.list.size(); i++) {
            int index = this.indexOfMinimum(i);
            super.swapWithAnimation(i, index);
        }
    }

    private int indexOfMinimum(int startIndex) {
        int min = this.list.get(startIndex);
        int minIndex = startIndex;

        for (int i = startIndex + 1; i < this.list.size(); i++) {
            if (this.list.get(i) < min) {
                minIndex = i;
                min = this.list.get(i);
            }
        }
        return minIndex;
    }
}
