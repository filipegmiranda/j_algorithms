package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String... args) {
        int[] array = {3,4,5,1,3,4,4,-1};
        int[] expected = {-1,1,3,3,4,4,4,5};

        array = mergeSort(array);
        assert Arrays.equals(array, expected);

    }

    public static int[] mergeSort(int[] array) {

        return null;
    }




}
