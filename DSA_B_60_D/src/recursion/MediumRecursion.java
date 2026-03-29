package recursion;

import java.util.ArrayList;

public class MediumRecursion {

    public static void main(String[] args) {
        // Subset of uniquie array
        int[] nums = {1, 2, 2,3,3,4,6,9,9,10};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        subsetOfUniqueArray(nums, ans, result, 0);
        System.out.println("Subset of unique array: "+result);
        int[] zaggleArr = {2,6,8,3,5,8,4,6,10,23,32,23,32};
        // sort the array then call the subset of unique array function
    }

    public static void subsetOfUniqueArray(int[] nums, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> result, int index){

        // Base case
        if(index == nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        // recursion case
        // inclusion case
        ans.add(nums[index]);
        subsetOfUniqueArray(nums, ans, result, index+1);
        // exclusion case
        ans.remove(ans.size()-1);
        int current = index;
        while(current+1<nums.length && nums[current] == nums[current+1]){
            current++;
        }
        subsetOfUniqueArray(nums, ans, result, current+1);
    }
}
