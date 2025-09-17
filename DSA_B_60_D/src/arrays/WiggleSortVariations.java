package arrays;

import java.util.concurrent.ThreadLocalRandom;

public class WiggleSortVariations {
    public static void main(String[] args) {
        int[] num = {3,5,2,1,6,4};
        wiggleSortI(num);
        int[] nums = {1, 5, 1, 1, 6, 4};
        int[] nums = {1,5,1,1,6,4};
        wiggleSortII(nums);
    }
    public static void wiggleSortI(int[] num){
        for(int i = 0;i<num.length-1;i++){
            if((i%2==0 && num[i]<num[i+1]) || (i%2==1 && num[i]>num[i+1])){
                // swap 
                int temp = num[i];
                num[i] = num[i+1];
                num[i+1] = temp;
            }
        }
        show(num);
    }

    public static void wiggleSortII(int[] nums){
        int n = nums.length;
        if (n <= 1) return;

        // Find median using a randomized quickselect on a copy to preserve original order for partitioning
        int[] copy = nums.clone();
        int median = quickSelect(copy, 0, n - 1, n / 2);

        // 3-way partition with virtual indexing
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            int vi = virtualIndex(i, n);
            int vl = virtualIndex(left, n);
            int vr = virtualIndex(right, n);

            if (nums[vi] > median) {
                swap(nums, vl, vi);
                left++;
                i++;
            } else if (nums[vi] < median) {
                swap(nums, vi, vr);
                right--;
            } else {
                i++;
            }
        }
        show(nums);
    }

    // Virtual index mapping to place larger elements at odd indices first
    private static int virtualIndex(int idx, int n) {
        return (1 + 2 * idx) % (n | 1);
    }

    // Randomized quickselect to find k-th smallest (0-based)
    private static int quickSelect(int[] a, int left, int right, int k) {
        while (left <= right) {
            int pivotIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
            int pivotFinal = partition(a, left, right, pivotIndex);

            if (pivotFinal == k) {
                return a[pivotFinal];
            } else if (k < pivotFinal) {
                right = pivotFinal - 1;
            } else {
                left = pivotFinal + 1;
            }
        }
        // should not reach here for valid k
        return a[left];
    }

    // Partition using Lomuto-style: pivot moved to end then partitioned
    private static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivotVal = a[pivotIndex];
        swap(a, pivotIndex, right);
        int store = left;
        for (int i = left; i < right; i++) {
            if (a[i] < pivotVal) {
                swap(a, store, i);
                store++;
            }
        }
        swap(a, store, right); // move pivot to its final place
        return store;
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    
    }
    public static void show(int[] num){
        for(int n : num){
            System.out.print(n+" ");
        }
        System.out.println(" ");
    }

    // Variations of wiggle-II
    public static void wiggleSortII(int[] nums){
        int median = findKthLarget(nums, (nums.length+1)/2);
        int n = nums.length;
        int i = 0, left = 0, right = n-1;
        while(i<=right){
            if(nums[newIndex(i,n)]>median){
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }else if(nums[newIndex(i,n)]<median){
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }else{
                i++;
            }
        }
        show(nums);
    }
    private static int findKthLarget(int[] num, int k){
        k = num.length-k;
        int low= 0, high = num.length-1;
        while(low<high){
            final int j = partition(num, low, high);
            if(j<k){
                low = j+1;
            }else if(j>k){
                high = j -1;
            }else{
                break;
            }
        }
        return num[k];
    }

    private static int partition(int[] nums, int left, int right){
        
    }
}
