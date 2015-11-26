package stackoverflow;

import java.util.Arrays;

public class SeggregateZeroOneTwos {

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 1, 2, 2, 0, 0, 1 };
        arrangeNumbers(a);
        System.out.println(Arrays.toString(a));
    }

    public static void arrangeNumbers(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int i = 0;
        while (i <= high) {
            if (arr[i] < 1) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] > 1) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}