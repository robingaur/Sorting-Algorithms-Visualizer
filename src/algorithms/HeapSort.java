package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class HeapSort extends AbstractAlgorithms {

    public HeapSort(List<Integer> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {

        int n = this.list.size();

        // Heapify array for each parent
        for (int i = n / 2 - 1; i >= 0; i--) {
            this.heapify(n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            super.swapWithAnimation(0, i);
            this.heapify(i, 0);
        }
    }

    /**
     * @param n is index of last element or current array size - 1.
     * @param i
     */
    private void heapify(int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n && super.list.get(left) > super.list.get(largest)) {
            largest = left;
        }

        if (right < n && super.list.get(right) > super.list.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            super.swapWithAnimation(i, largest);
            this.heapify(n, largest);
        }
    }
}