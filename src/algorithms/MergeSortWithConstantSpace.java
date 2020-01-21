package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.List;

public class MergeSortWithConstantSpace extends AbstractAlgorithms {

    public MergeSortWithConstantSpace(List<Integer> list, RectangleInterface rectangle) {
        super(list, rectangle);
    }

    @Override
    protected void sort() {
        this.sort(0, this.list.size() - 1);
    }

    private void sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            this.sort(start, mid);
            this.sort(mid + 1, end);

            this.merge(start, mid, end);
        }
    }

    private void merge(int start, int mid, int end) {

        for (int i = mid; i >= start; i--) {
            for (int j = i; j < end; j++) {
                if (super.list.get(j) > super.list.get(j + 1)) {
                    super.swapWithAnimation(j, j + 1);
                } else {
                    break;
                }
            }
        }
    }
}
