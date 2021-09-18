package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(
                binarySearch(new int[]{2, 4, 5, 7, 9}, 7, 0, 4));
    }

    public static boolean binarySearch(int[] data, int target, int low, int high){
        if(low > high){
            return false;
        }else {
            int mid = (low + high) / 2;
            if(target == data[mid]){
                return true;
            }else if(target < data[mid]){
                return binarySearch(data, target, low, mid -1);
            }else{
                return binarySearch(data, target, mid + 1, high);
            }
        }
    }

    private static boolean binarySearchIterative(int[] data, int target){
        int low = 0;
        int high = data.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(target == data[mid]){
                return true;
            }else if(target < data[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }
}
