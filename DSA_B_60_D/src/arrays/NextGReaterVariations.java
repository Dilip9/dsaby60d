package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGReaterVariations {
    public static void main(String[] args) {
        // next greater element
        int[] nums1 = {1,6,4,8};
        int[] nums2 = {3,8,4,9,12,1,2,7,2};
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

    public static void findNextGreaterElementII(int[] array){
        Stack<Integer> stack = new Stack<>();
        int n = array.length;
        int[] result = new int[n];
        for(int i = 2*n-1;i>=0;i--){
            while(!stack.isEmpty() && array[stack.peek()]<=array[i%n]){
                stack.pop();
            }
            result[i%n] = stack.isEmpty()?-1:array[stack.peek()];
            stack.push(i%n);
        }
        System.out.println("Second and medium variations of next greater element... ");
        show(result);
     }

    public static void show(int[] arr){
        for(int n : arr){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
