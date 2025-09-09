package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGReaterVariations {
    public static void main(String[] args) {
        // next greater element
        int[] nums1 = {1,6,4,8};
        int[] nums2 = {3,8,4,9,12};
        // Basics to find next greater element.
        findNextGreaterElement(nums1, nums2);
        // Medium Variations
        findNextGreaterElementII(nums2);
    }
    public static void findNextGreaterElement(int[] num1, int[] num2){
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : num2){
            while (!stack.isEmpty() && stack.peek()<num) {
                nextGreater.put(stack.pop(), num);
                
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
            
        }
        int[] result = new int[num1.length];
        for(int i=0;i<num1.length;i++){
            result[i] = nextGreater.getOrDefault(num1[i], -1);
        }
        show(result);
    }

    public static void findNextGreaterElementII(){}

    public static void show(int[] arr){
        for(int n : arr){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
