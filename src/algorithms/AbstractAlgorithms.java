package algorithms;

import UtilityClasses.Rectangle;

import java.awt.*;
import java.util.List;

public abstract class AbstractAlgorithms implements Runnable, AlgorithmsInterface {

    protected List<Number> list;
    private Rectangle rectangle;
    private int animationSpeed;

    public AbstractAlgorithms(List<Number> list, Rectangle rectangle) {
        this.list = list;
        this.rectangle = rectangle;
        this.animationSpeed = 10;
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
        try {
            // Red Rectangle
            this.rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.RED);
            this.rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.RED);
            Thread.sleep(5 * this.getAnimationSpeed());

            // Delete Red Rectangle (Delete Rectangle at all)
            this.rectangle.removeAtIndex(i, this.list.get(i).intValue());
            this.rectangle.removeAtIndex(j, this.list.get(j).intValue());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    protected void drawGreenRectangle(int i, int j) {
        try {
            this.rectangle.drawAtIndex(i, this.list.get(i).intValue(), Color.GREEN);
            this.rectangle.drawAtIndex(j, this.list.get(j).intValue(), Color.GREEN);
            Thread.sleep(this.getAnimationSpeed());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    protected void currentlySelected() {
    }

    @Override
    public void setAnimationSpeed(int speed) {
        this.animationSpeed = speed;
    }

    @Override
    public int getAnimationSpeed() {
        return this.animationSpeed;
    }
}
