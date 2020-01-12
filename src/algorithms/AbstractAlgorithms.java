package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;

public abstract class AbstractAlgorithms implements Runnable, AlgorithmsInterface {

    protected List<Number> list;
    private Rectangle rectangle;
    private double animationDelay;

    public AbstractAlgorithms(List<Number> list, Rectangle rectangle) {
        this.list = list;
        this.rectangle = rectangle;
        this.animationDelay = 10.0;
    }

    @Override
    public void run() {
        this.sort();
    }

    abstract void sort();

    protected void swapWithAnimation(int i, int j) {
        Number temp;
        this.drawAndDeleteRedRectangle(i, j);

        // Swap the items in the list
        temp = this.list.get(i);
        this.list.set(i, this.list.get(j));
        this.list.set(j, temp);

        // Update the Rectangle to their new position.
        this.drawGreenRectangle(i, j);
    }

    protected void drawAndDeleteRedRectangle(int i, int j) {

        // Red Rectangle
        this.rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.RED);
        this.rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.RED);

        try {
            Thread.sleep((int) (5 * this.getAnimationDelay()));
        } catch (InterruptedException ex) {
        }

        // Delete Red Rectangle (Delete Rectangle at all)
        this.rectangle.removeAtIndex(i, this.list.get(i).intValue());
        this.rectangle.removeAtIndex(j, this.list.get(j).intValue());

    }

    protected void drawGreenRectangle(int i, int j) {
        this.rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.GREEN);
        this.rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.GREEN);

        try {
            Thread.sleep((int) this.getAnimationDelay());
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void setAnimationDelay(double delay) {
        this.animationDelay = delay;
    }

    @Override
    public double getAnimationDelay() {
        return this.animationDelay;
    }
}
