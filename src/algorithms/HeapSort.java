package algorithms;

import UtilityClasses.Rectangle;

import java.util.List;

public class HeapSort extends AbstractAlgorithms {

    public HeapSort(List<Number> list, Rectangle rectangle) {
        super(list, rectangle);
    }

    @Override
    void sort() {

        int n = this.list.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            this.heapify(n, i);

        for (int i = n - 1; i >= 0; i--) {
            super.swapWithAnimation(0, i);
            this.heapify(i, 0);
        }
    }

    private void heapify(int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n && super.list.get(left).intValue() > super.list.get(largest).intValue()) {
            largest = left;
        }

        if (right < n && super.list.get(right).intValue() > super.list.get(largest).intValue()) {
            largest = right;
        }

        if (largest != i) {
            super.swapWithAnimation(i, largest);
            this.heapify(n, largest);
        }
    }
}
