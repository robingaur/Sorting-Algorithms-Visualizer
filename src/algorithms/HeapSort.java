package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeapSort {

    private List<Number> list;

    public HeapSort(List<Number> list) {
        this.list = list;
    }

    public void sort(Rectangle rectangle) {

        int n = this.list.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            this.heapify(rectangle, n, i);

        for (int i = n - 1; i >= 0; i--) {
            this.swap(rectangle, 0, i);
            this.heapify(rectangle, i, 0);
        }
    }

    private void heapify(Rectangle rectangle, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;


        if (left < n && this.list.get(left).intValue() > this.list.get(largest).intValue()) {
            largest = left;
        }

        if (right < n && this.list.get(right).intValue() > this.list.get(largest).intValue()) {
            largest = right;
        }

        if (largest != i) {
            this.swap(rectangle, i, largest);
            this.heapify(rectangle, n, largest);
        }
    }

    private void swap(Rectangle rectangle, int i, int j) {
        try {
            Number temp;
            // Red Rectangle
            rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.RED);
            rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.RED);
            TimeUnit.MILLISECONDS.sleep(50);

            // Delete Red Rectangle (Delete Rectangle at all)
            rectangle.removeAtIndex(i, this.list.get(i).intValue());
            rectangle.removeAtIndex(j, this.list.get(j).intValue());

            // Swap the items in the list
            temp = this.list.get(i);
            this.list.set(i, this.list.get(j));
            this.list.set(j, temp);

            // Update the Rectangle to their new position.
            rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.GREEN);
            rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.GREEN);
            TimeUnit.MILLISECONDS.sleep(10);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
