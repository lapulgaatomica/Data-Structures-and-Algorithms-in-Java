package recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void reverseArray(int[] data, int low, int high){
        if(low < high){
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);
        }
    }

    public static void reverseArray(int[] data){
        reverseArray(data, 0, data.length -1);
    }

    public static void reverseIterative(int[] data){
        int low = 0, high = data.length - 1;
        while (low < high){
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        reverseArray(array);
        System.out.println(Arrays.toString(array));
    }
}
