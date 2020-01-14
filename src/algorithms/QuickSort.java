package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class QuickSort extends AbstractAlgorithms {

    public QuickSort(List<Number> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {
        this.sort(0, this.list.size() - 1);
    }

    private void sort(int start, int end) {
        if (start < end) {
            int partition = this.partition(start, end);
            this.sort(start, partition - 1);
            this.sort(partition + 1, end);
        }
    }

    private int partition(int low, int high) {
        int pivot = super.list.get(high).intValue();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (super.list.get(j).intValue() < pivot) {
                i++;
                super.swapWithAnimation(i, j);
            }
        }

        super.swapWithAnimation(i + 1, high);
        return i + 1;
    }
}
