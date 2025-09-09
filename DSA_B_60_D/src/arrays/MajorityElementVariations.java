package arrays;

public class MajorityElementVariations {
    public static void main(String[] args) {
        int[] random = {2,2,2,5,3,6,2,2,2,2,3,4,2,2,2,6,4,2,5,2,6,2,2,5,2,3,4,3,6,2,2,5,3,4,1,12,2,2,2,2};
        findMajorityNumberI(random);
    }
    public static void findMajorityNumberI(int[] nums){
        int count = 1;
        int candidate = nums[0];
        for(int i = 1; i<nums.length;i++){
            if(nums[i]== candidate){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
        }
        count =0;
        for(int n: nums){
            if(candidate == n){
                count++;
            }
        }
        if(count>nums.length/2){
            System.out.println("Majority element which is present on an array is:::"+candidate);
        }else{
            System.out.println("No Majority element found..");
        }
    }
}
