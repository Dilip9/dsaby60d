package sorts;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,4,6,7,3);
        insertionSortStepWise(nums);
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

    public static void printArray(List<Integer> nums){
        for(int n : nums){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}
