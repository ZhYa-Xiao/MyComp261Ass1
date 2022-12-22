import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,2,5,3,3,2,6,7,8,3,4};
        InsetSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void InsetSort(int arr[]){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {//将条件写入循环判定中，相当于把break也写入了
                swap(arr,j);
            }
        }
    }

    public static void swap(int arr[], int j){
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
    }
}
