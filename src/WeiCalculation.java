public class WeiCalculation {
    public static void main(String[] args) {
        int[] arr ={1,1,2,2,2,4,4,4,4,7,7,7};

        int eor = 0;
        for (int i=0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        int rightOne = eor & (~eor + 1);//提取出最右边的1
        //当eor的某一位等于1的时候，就代表这一个位上的a,b数字必不相同，故引出用该位置的数字来把a,b划分到两个组
        int onlyOne = 0;
        int on=0;
        for(int cur:arr) {
            //0000000100
            if((cur & rightOne) == 1) {//因为rightOne除了第八位其他几位全是0，故与的结果只看第八位
                onlyOne ^= cur;
            }

            if((cur & rightOne) == 0){//代表此时的cur的第八位上是0，也就是取出0组的数
                on^=cur;
            }
        }

        System.out.println(eor^onlyOne);
        System.out.println(eor^on);
    }
}
