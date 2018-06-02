package sorting;

import java.util.Arrays;
import static sorting.SortingHelper.*;

public class Shellsort {


    public static void main(String... args) {
        int[] inputArray = {3,4,5,1,3,4,4,-1,15,14,13,12,11,10};
        int[] expected = {-1,1,3,3,4,4,4,5,10,11,12,13,14,15};
        int[] sorted = shellSort(inputArray);
        assert Arrays.equals(sorted, expected);
    }

    public static int[] shellSort(int[] a) {
        int n = a.length;

        int h = 1;

        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a, j , j -h); j =- h) {
                    swap(a, j, j - h);
                }
            }

            h = h / 3;
        }
        return a;
    }

}
