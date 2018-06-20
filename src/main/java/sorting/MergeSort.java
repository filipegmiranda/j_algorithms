package sorting;

import java.util.Arrays;
import static sorting.SortingHelper.*;

public class MergeSort {

    public static void main(String... args) {
        int[] array = {3,4,5,1,3,4,4,-1};
        int[] expected = {-1,1,3,3,4,4,4,5};

        array = mergeSort(array);
        assert Arrays.equals(array, expected);
    }

    public static int[] mergeSort(int[] array) {
        sort(array, new int[array.length], 0, array.length -1);
        return array;
    }

    private static void sort(int[] array, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private static void merge(int[] array, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k ++) {
            aux[k] = array[k];
        }
        int k = lo;
        int i = lo;
        int j = mid + 1;
        while (k <= hi) {
            if (i > mid) array[k++] = aux[j++];
            else if (j > hi) array[k++] = aux[i++];
            else if (less(aux, j, i)) array[k++] = aux[j++];
            else array[k++] = aux[i++];
            //else array[k++] = aux[j++];
        }
    }

}
