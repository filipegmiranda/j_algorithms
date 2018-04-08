package main.java.sorting;

import java.util.Arrays;


public class QuickSort {

    public static void main(String... args) {
        int array[] = {2, 3, 4, 1, 11, 5, 7, 0, 10, -1, 99, 23};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int array[]) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int array[], int l, int r) {
        if (l >= r) {
            return;
        }
        int p = lomutoPartition(array, l, r);//hoarePartition(array, l, r);//lomutoPartition(array, l, r);
        quickSort(array, l, p - 1);
        quickSort(array, p + 1, r);
    }

    private static int lomutoPartition(int array[], int l, int r) {
        //pivot chosen
        int pivot = array[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, r);
        return i + 1;
    }


    private static int hoarePartition(int array[], int l, int r) {
        int pivot = array[r];
        int left = l;
        int right = r;
        while (true) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left >= right) {
                return left;
            }
            swap(array, left, right);
        }
    }

    private static void swap(int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
