package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract class AbstractAlgorithms implements Runnable, AlgorithmsInterface {

    protected List<Number> list;
    protected Rectangle rectangle;

    public AbstractAlgorithms(List<Number> list, Rectangle rectangle) {
        this.list = list;
        this.rectangle = rectangle;
    }

    @Override
    public void run() {
        this.sort();
    }

    abstract void sort();

    protected void swap(int i, int j) {
        try {
            Number temp;
            // Red Rectangle
            this.rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.RED);
            this.rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.RED);
            TimeUnit.MILLISECONDS.sleep(50);

            // Delete Red Rectangle (Delete Rectangle at all)
            this.rectangle.removeAtIndex(i, this.list.get(i).intValue());
            this.rectangle.removeAtIndex(j, this.list.get(j).intValue());

            // Swap the items in the list
            temp = this.list.get(i);
            this.list.set(i, this.list.get(j));
            this.list.set(j, temp);

            // Update the Rectangle to their new position.
            this.rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.GREEN);
            this.rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.GREEN);
            TimeUnit.MILLISECONDS.sleep(10);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    protected void currentlySelected() {
    }
}
