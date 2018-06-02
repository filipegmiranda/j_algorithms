package sorting;
import java.util.Arrays;

import static sorting.SortingHelper.*;

public class SelectionSort {

    public static void main(String... args) {
        int[] array = {3,4,5,1,3,4,4,-1};
        int[] expected = {-1,1,3,3,4,4,4,5};
        int[] orderedArray = selectionSort(array);
        assert Arrays.equals(orderedArray, expected);
    }


    public static int[] selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++ ) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
        return a;
    }

}
