package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class BubbleSort extends AbstractAlgorithms {

    public BubbleSort(List<Number> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {
        for (int i = 0; i < super.list.size(); i++) {
            for (int j = 0; j < super.list.size() - i - 1; j++) {
                if (super.list.get(j).intValue() > super.list.get(j + 1).intValue()) {
                    super.swapWithAnimation(j, j + 1);
                }
            }
        }
    }
}
