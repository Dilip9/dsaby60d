package sorts;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,4,6,7,3);
        insertionSortStepWise(nums);
        int[] aray = {43,65,23,76,34,87,34,24,43,345,23,56,432,12,6,23,876,965,4,233,23,65,34,54,768,56,23}; 
        insertionSort(aray);
    }


    public static void insertionSortStepWise(List<Integer> num){
        int n = num.size();
        int valueToInsertAtRightPosition = num.get(n-1);
        int i = n-2;
        while(i>=0 && num.get(i)>valueToInsertAtRightPosition){
            num.set(i+1, num.get(i));
            printArray(num);
            i--;
        }
        num.set(i+1, valueToInsertAtRightPosition);
        printArray(num);
    }

    public static void insertionSort(int[] nums){
        
    for (int i = 1; i < nums.length; i++) {
                int value = nums[i];
                int j = i - 1;

                while (j >= 0 && nums[j] > value) {
                    nums[j + 1] = nums[j];
                    j--;
                }

                nums[j + 1] = value;

                System.out.println("Step " + i + ":");
                printArrays(nums);
            }

    }
    public static void printArray(List<Integer> nums){
        for(int n : nums){
            System.out.print(n+" ");
        }
        System.out.println();
    }

    public static void printArrays(int[] n){
        for(int nn: n){
            System.out.print(nn+" ");
        }
    }
}
