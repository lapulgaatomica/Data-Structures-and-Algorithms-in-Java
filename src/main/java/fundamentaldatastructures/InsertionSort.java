package fundamentaldatastructures;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(
                new Character[]{'B', 'C', 'D', 'A', 'E', 'H', 'G', 'F'})));
        System.out.println(Arrays.toString(insertionSort(
                new Integer[]{3, 1, 4, 5, 6, 7, 7})));
    }

    public static <T extends Comparable<T>> T[] insertionSort(T[] data){
        int n = data.length;

        for(int k = 1; k < n; k++){
            T cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1].compareTo(cur) > 0){
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }

        return data;
    }
}
