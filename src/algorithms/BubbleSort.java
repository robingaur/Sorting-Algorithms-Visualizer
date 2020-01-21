package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class BubbleSort extends AbstractAlgorithms {

    public BubbleSort(List<Integer> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {

        boolean isSwaped = true;
        while (isSwaped) {
            isSwaped = false;
            for (int i = 1; i < super.list.size(); i++) {
                if (super.list.get(i - 1) > super.list.get(i)) {
                    isSwaped = true;
                    super.swapWithAnimation(i - 1, i);
                }
            }
        }
    }
}
