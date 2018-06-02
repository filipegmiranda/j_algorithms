package sorting;

import java.util.Arrays;
import static sorting.SortingHelper.*;

public class InsertionSort {

    public static void main(String... args) {
        int[] inputArray = {3,4,5,1,3,4,4,-1,15,14,13,12,11,10};
        int[] expected = {-1,1,3,3,4,4,4,5,10,11,12,13,14,15};
        int[] sorted = insertionSort(inputArray);
        assert Arrays.equals(sorted, expected);
    }

    public static int[] insertionSort(int[] a) {
        for (int i = 0; i < a.length; i ++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a,j - 1, j);
                } else break;
            }
        }
        return a;
    }

}
