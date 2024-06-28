public class KConcatenate {
    public static void main(String[] args){
        int[] arr = {10000,10000,10000,10000,10000,10000,10000,10000,10000,10000};
        System.out.println(kConcatenationMaxSum(arr, 100000));
    }
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int arrCount = 0, max_so_far = Integer.MIN_VALUE, max_ending_here = 0, arrSize;

        int[] newArr;
        int arrLength = arr.length * k;

        if(arrLength > 100000)
            newArr = new int[100000];
        else
            newArr = new int[arrLength];

        for(int i = 0; i < newArr.length; i++){
            newArr[i] = arr[arrCount];
            arrCount++;

            if(arrCount == arr.length){
                arrCount = 0;
            }
        }

        arrSize = newArr.length;

        for (int i = 0; i < arrSize; i++) {
            max_ending_here += newArr[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here ;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }

        if (max_so_far < 0)
                max_so_far = 0;

        int M = 1000000007;
        
        return max_so_far % M;
    }
}
