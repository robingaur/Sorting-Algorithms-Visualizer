package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class BubbleSort extends AbstractAlgorithms {

    public BubbleSort(List<Number> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {

        boolean isSwaped = true;
        while (isSwaped) {
            isSwaped = false;
            for (int i = 1; i < super.list.size(); i++) {
                if (super.list.get(i - 1).intValue() > super.list.get(i).intValue()) {
                    isSwaped = true;
                    super.swapWithAnimation(i-1, i);
                }
            }
        }
    }
}
