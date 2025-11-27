package sliding_w_p;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Fixed_Window {
    public static void main(String[] args) {
        System.out.println("Fixed Window Pattern Problem ");
        /**
         * Given an array and integer k, find the maximum sum of any contiguous subarray of size k.
         * **/
        /**
         * First Negative Number in Every Window of Size K (Fixed Window)
         *
         * */
        maxSum(new int[]{2, 1, 5, 1, 3, 2},3);
        firstNegativeNumber(new int[]{-8, 2, 3, -6, 10},2);
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
    public static void firstNegativeNumber(int[] arr, int k){
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> dq = new LinkedList<>();

        for(int i =0;i<arr.length-1;i++){
            if(arr[i]<0){
                dq.add(i);
            }
            if(i>=k-1){
                if(!dq.isEmpty() && dq.peek()<= i-k){
                    dq.poll();
                }
                result.add(dq.isEmpty()?0:arr[dq.peek()]);
            }
        }
        System.out.println("First Negative Number in every window of size k : "+result);
    }
}