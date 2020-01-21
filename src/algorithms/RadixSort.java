package algorithms;

import UtilityClasses.RectangleInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort extends AbstractAlgorithms {

    private int base;

    public RadixSort(List<Integer> list, RectangleInterface rectangle) {
        super(list, rectangle);
        this.base = 10;
    }

    @Override
    protected void sort() {
        int maxDataValue = Collections.max(super.list);

        for (int exp = 1; maxDataValue / exp > 0; exp *= this.base) {
            this.countSort(exp);
        }
    }

    private void countSort(int exp) {
        List<Integer> unsortedList = new ArrayList<>(super.list);

        int count[] = new int[this.base];
        Arrays.fill(count, 0);

        for (int i = 0; i < unsortedList.size(); i++) {
            count[(unsortedList.get(i) / exp) % this.base]++;
        }

        for (int i = 1; i < this.base; i++) {
            count[i] += count[i - 1];
        }

        for (int i = this.base - 1; i > 0; i--) {
            count[i] = count[i - 1];
        }
        count[0] = 0;


        int index;
        for (int i = 0; i < unsortedList.size(); i++) {
            index = count[(unsortedList.get(i) / exp) % this.base];

            super.drawAndDeleteRedRectangle(index, index);

            super.list.set(index, unsortedList.get(i));
            count[(unsortedList.get(i) / exp) % this.base]++;

            super.drawGreenRectangle(index, index);
        }
    }
}