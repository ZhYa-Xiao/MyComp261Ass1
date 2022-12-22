import java.util.Arrays;

public class Heap_ {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,3,1,1,6,7,8,4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1)/2]) {
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i=0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index) {
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = 2 * index + 1;
        }
    }
}
