import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Dichotomy {
    public static void main(String[] args) {
        int testTime = 5;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i=0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);

            if(!isEqual(arr1,arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked");

    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random() * (maxSize + 1))];
        for (int i=0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int)((maxValue) * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if(arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i=0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || arr1 != null & arr2 == null) {
            return false;
        }
        for (int i=0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test(){
        int[] arr = {1,3,4,2,5,2,3,2,1};
//        MergeSort(arr,0,arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//        process(arr,0,arr.length - 1);
        fastSort(arr,0,arr.length - 1);
    }

    //二分法确认数组中是否存在该数
    public static boolean DichotomySort(int arr[], int a) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;

            if(a == arr[mid]) {
                return true;
            } else if(a > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    //找到>=某个值的最左边的数
    public static int DichotomyLeft(int arr[], int a) {
        int index = 0;
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end)/2;
            //大于时向右找
            if(a > arr[mid]) {
                start = mid + 1;
            //小于或等于时都往左找
            } else if(a <= arr[mid]) {
                end = mid - 1;
            }
        }
        return start;
    }

    //找到局部最小值
    public static int DichotomyMin(int arr[]) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end)/2;

        if(arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        while (start <= end) {
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                index = mid;
                System.out.println("执行第一条语句");
                break;
            } else if(arr[mid - 1] < arr[mid]) {
                end = mid - 1;
                System.out.println("执行第二条语句");
            } else if(arr[mid + 1] < arr[mid]) {
                start = mid + 1;
                System.out.println("执行第三条语句");
            } else {
                System.out.println("没找到");
            }
            mid = (start + end)/2;
        }

        return index;
    }

    //归并排序法
    public static void MergeSort(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = (L + R)/2;
        MergeSort(arr,L,mid);
        MergeSort(arr,mid + 1,R);
        Merge(arr,L,mid,R);
    }

    //合并方法
    public static void Merge(int[] arr,int L,int mid,int R) {
        int i = L;
        int j = mid + 1;
        int k = 0;
        int[] help = new int[R - L + 1];
        for (;i <= mid && j <= R;k++) {
            if(arr[i] >= arr[j]) {
                help[k] = arr[i];
                i++;
            } else if(arr[i] < arr[j]) {
                help[k] = arr[j];
                j++;
            }
        }

        //当划分数组左右两端不匹配时，将多出来的部分拷贝到数组末尾
        while (i <= mid) {
            help[k++] = arr[i++];
        }

        while (j <= R) {
            help[k++] = arr[j++];
        }

        for (int l=0; l < help.length; l++) {
            arr[L + l] = help[l];
        }
    }


    //求最小和
    public void process(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = (L + R)/2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int i = L;
        int j = mid + 1;
        int k = 0;
        int[] help = new int[R - L + 1];
        while (i <= mid && j <= R) {
            if(arr[j] < arr[i]) {
                int count = 0;
                int[] com = new int[mid - L + 2];
                for (int m=i; m <= mid ; m++) {
                    com[count++] = arr[m];
                }
                com[count] = arr[j];
                help[k++] = arr[j++];
                System.out.println(Arrays.toString(com));
            } else {
                help[k++] = arr[i++];
            }
        }

        //当划分数组左右两端不匹配时，将多出来的部分拷贝到数组末尾
        while (i <= mid) {
            help[k++] = arr[i++];
        }

        while (j <= R) {
            help[k++] = arr[j++];
        }

        for (int l=0; l < help.length; l++) {
            arr[L + l] = help[l];
        }

    }

    //交换函数
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //快排
    public static void fastSort(int[] arr,int L,int R) {
        if(L < R) {
            int r=(int) (L + Math.random() * (R - L + 1));
            swap(arr, r, R);
            int[] a=quick(arr, L, R);
            fastSort(arr, L, a[0] - 1);
            fastSort(arr, a[1] + 1, R);
        }
    }

    public static int[] quick(int[] arr,int L,int R) {
        int[] a = new int[2];
        int num = arr[R];
        int i = L;
        while (i <= R) {
            if(arr[i] > num) {
                swap(arr,i,(--R));
            } else if(arr[i] <num) {
                swap(arr,i++,(++L));
            }
        }
        a[0] = L;
        a[1] = R;
        return a;
    }

    //快排答案
    public static void fastSort01(int[] arr,int L,int R) {
        if(L < R) {
            int r=(int) (L + Math.random() * (R - L + 1));
            swap(arr, r, R);
            int[] a=quick(arr, L, R);
            fastSort(arr, L, a[0] - 1);
            fastSort(arr, a[1] + 1, R);
        }
    }

    public static int[] quick01(int[] arr,int L,int R) {
        int less = L - 1;//左边界
        int more = R;//右边界
        while (L < more) {
            if(arr[L] > arr[R]) {
                swap(arr,--more,L);
            } else if(arr[L] < arr[R]) {
                swap(arr,++less,L++);
            } else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[] {less + 1, more};
    }
}

