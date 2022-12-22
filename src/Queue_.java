import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Queue_ {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,3,1,1,6,7,8,4};
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for (int i=0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}

//哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈