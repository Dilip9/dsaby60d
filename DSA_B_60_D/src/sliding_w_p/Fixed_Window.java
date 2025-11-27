public class Fixed_Window {
    public static void main(String[] args) {
        System.out.println("Fixed Window Pattern Problem ");
        /**
         * Given an array and integer k, find the maximum sum of any contiguous subarray of size k.
         * **/
        maxSum(new int[]{2, 1, 5, 1, 3, 2},3);
    }
    public static void maxSum(int[] arr, int k){
        int sum = 0;
        int maxSum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        maxSum = sum;
        for(int i=k;i<arr.length;i++){
            sum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println("Max Sum of Subarray of size k is : "+maxSum);
    }
}