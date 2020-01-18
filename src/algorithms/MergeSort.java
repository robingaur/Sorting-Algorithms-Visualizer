package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class MergeSort extends AbstractAlgorithms {

    public MergeSort(List<Number> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {
        this.sort(0, this.list.size() - 1);
    }

    private void sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            this.sort(start, mid);
            this.sort(mid + 1, end);

            this.merge(start, mid, end);
        }
    }

    private void merge(int start, int mid, int end) {
        // Sizes of the Array
        int sizeOfLeftArray = mid - start + 1;
        int sizeOfRightArray = end - mid;

        int[] left = new int[sizeOfLeftArray];
        int[] right = new int[sizeOfRightArray];

        for (int i = 0; i < sizeOfLeftArray; i++) {
            left[i] = super.list.get(start + i).intValue();
        }

        for (int i = 0; i < sizeOfRightArray; i++) {
            right[i] = super.list.get(mid + i + 1).intValue();
        }

        int i = 0, j = 0, k = start;
        while (i < sizeOfLeftArray && j < sizeOfRightArray) {
            super.drawAndDeleteRedRectangle(k, k);

            if (left[i] <= right[j]) {
                super.list.set(k, left[i]);
                i++;
            } else {
                super.list.set(k, right[j]);
                j++;
            }

            super.drawGreenRectangle(k, k);
            k++;
        }

        while (i < sizeOfLeftArray) {
            super.drawAndDeleteRedRectangle(k, k);
            this.list.set(k, left[i]);
            i++;

            super.drawGreenRectangle(k, k);
            k++;
        }

        while (j < sizeOfRightArray) {
            super.drawAndDeleteRedRectangle(k, k);
            this.list.set(k, right[j]);
            j++;

            super.drawGreenRectangle(k, k);
            k++;
        }
    }
}
