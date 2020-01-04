package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuickSort {

    private List<Number> list;

    public QuickSort(List<Number> list) {
        this.list = list;
    }

    public void sort(Rectangle rectangle) {
        this.sort(rectangle, 0, this.list.size() - 1);
    }

    private void sort(Rectangle rectangle, int start, int end) {
        if (start < end) {
            int partition = this.partition(rectangle, start, end);
            this.sort(rectangle, start, partition - 1);
            this.sort(rectangle, partition + 1, end);
        }
    }

    private int partition(Rectangle rectangle, int low, int high) {
        try {
            int pivot = this.list.get(high).intValue();
            int i = low - 1;

            rectangle.drawAtIndex(pivot, this.list.get(pivot).intValue(), Color.BLUE);
            TimeUnit.MILLISECONDS.sleep(10);

            for (int j = low; j < high; j++) {
                if (this.list.get(j).intValue() < pivot) {
                    i++;
                    this.swap(rectangle, i, j);
                }
            }

            this.swap(rectangle, i + 1, high);
            return i + 1;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return 0;
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
