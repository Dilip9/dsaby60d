package arrays;

public class WiggleSortVariations {
    public static void main(String[] args) {
        int[] num = {3,5,2,1,6,4};
        wiggleSortI(num);
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
