package recursion;

import java.util.Arrays;

public class LinearSum {
    public static int linearSum(int[] data, int n){
        if(n == 0){
            return 0;
        }else{
//            System.out.println(Arrays.toString(data));
//            System.out.println(n);
            return linearSum(data, n - 1) + data[n - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(linearSum(new int[]{1, 2, 3, 4}, 4));
    }

//    public static int linearSum(int[] data){
//        int n = data.length - 1;
//        if(n == 0){
//            return data[n];
//        }else{
////            System.out.println(Arrays.toString(data));
////            System.out.println(n);
//            return linearSum(Arrays.copyOfRange(data, 0, n)) + data[n];
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(linearSum(new int[]{1, 2, 3, 4, 5}));
//    }
}
