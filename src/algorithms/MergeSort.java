package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MergeSort {

    private List<Number> list;

    public MergeSort(List<Number> list) {
        this.list = list;
    }

    public void sort(Rectangle rectangle) {
        this.sort(rectangle, 0, this.list.size() - 1);
    }

    private void sort(Rectangle rectangle, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            sort(rectangle, start, mid);
            sort(rectangle, mid + 1, end);

            this.merge(rectangle, start, mid, end);
        }
    }

    private void merge(Rectangle rectangle, int start, int mid, int end) {

        try {
            // Sizes of the Array
            int sizeOfLeftArray = mid - start + 1;
            int sizeOfRightArray = end - mid;

            int[] left = new int[sizeOfLeftArray];
            int[] right = new int[sizeOfRightArray];

            for (int i = 0; i < sizeOfLeftArray; i++) {
                left[i] = this.list.get(start + i).intValue();
            }

            for (int i = 0; i < sizeOfRightArray; i++) {
                right[i] = this.list.get(mid + i + 1).intValue();
            }

            int i = 0, j = 0, k = start;
            while (i < sizeOfLeftArray && j < sizeOfRightArray) {
                rectangle.drawAtIndex(k, this.list.get(k).intValue(), Color.RED);
                TimeUnit.MILLISECONDS.sleep(50);
                rectangle.removeAtIndex(k, this.list.get(k).intValue());

                if (left[i] <= right[j]) {
                    this.list.set(k, left[i]);
                    i++;
                } else {
                    this.list.set(k, right[j]);
                    j++;
                }
                rectangle.drawAtIndex(k, this.list.get(k).intValue(), Color.GREEN);
                k++;
            }

            while (i < sizeOfLeftArray) {
                rectangle.drawAtIndex(k, this.list.get(k).intValue(), Color.RED);
                TimeUnit.MILLISECONDS.sleep(50);

                rectangle.removeAtIndex(k, this.list.get(k).intValue());
                this.list.set(k, left[i]);
                i++;

                rectangle.drawAtIndex(k, this.list.get(k).intValue(), Color.GREEN);
                k++;
            }

            while (j < sizeOfRightArray) {
                rectangle.drawAtIndex(k, this.list.get(k).intValue(), Color.RED);
                TimeUnit.MILLISECONDS.sleep(50);

                rectangle.removeAtIndex(k, this.list.get(k).intValue());
                this.list.set(k, right[j]);
                j++;

                rectangle.drawAtIndex(k, this.list.get(k).intValue(), Color.GREEN);
                k++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
