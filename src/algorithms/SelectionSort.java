package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectionSort {

    private List<Number> list;

    public SelectionSort(List<Number> list) {
        this.list = list;
    }

    public void sort(Rectangle rectangle) {
        for (int i = 0; i < this.list.size(); i++) {
            int index = this.indexOfMinimum(i);
            this.swap(rectangle, i, index);
        }
    }

    private int indexOfMinimum(int startIndex) {
        int min = this.list.get(startIndex).intValue();
        int minIndex = startIndex;

        for (int i = startIndex + 1; i < this.list.size(); i++) {
            if (this.list.get(i).intValue() < min) {
                minIndex = i;
                min = this.list.get(i).intValue();
            }
        }
        return minIndex;
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
