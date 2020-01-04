package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BubbleSort {

    private List<Number> list;

    public BubbleSort(List<Number> list) {
        this.list = list;
    }

    public void sort(Rectangle rectangle) {
        try {
            Number temp;
            for (int i = 0; i < this.list.size(); i++) {
                for (int j = 0; j < this.list.size() - i - 1; j++) {

                    if (this.list.get(j).intValue() > this.list.get(j + 1).intValue()) {

                        // Red Rectangle
                        rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.RED);
                        rectangle.drawAtIndex(j + 1, this.list.get(j + 1).intValue(), Color.RED);
                        TimeUnit.MILLISECONDS.sleep(50);

                        // Delete Red Rectangle (Delete Rectangle at all)
                        rectangle.removeAtIndex(j, this.list.get(j).intValue());
                        rectangle.removeAtIndex(j + 1, this.list.get(j + 1).intValue());

                        // Swap the items in the list
                        temp = this.list.get(j);
                        this.list.set(j, this.list.get(j + 1));
                        this.list.set(j + 1, temp);

                        // Update the Rectangle to their new position.
                        rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.GREEN);
                        rectangle.drawAtIndex(j + 1, this.list.get(j + 1).intValue(), Color.GREEN);
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
