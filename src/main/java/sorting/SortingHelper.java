package sorting;


import java.util.Arrays;

public class SortingHelper {


    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }

    public static void printArray(int a[]) {
        System.out.println("array: " + Arrays.toString(a));
    }

}
