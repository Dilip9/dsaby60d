package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PgmPractice1 {
    // move all zero at the starting end.
    public static void main(String[] args) {
        int[] arr = {1,2,5,2,9,0,9,0,15,0,7,0};  // 1. problem move all zero at the end.
        printArray(arr);
        System.out.println("::::::::::::::::Before doing final operations::::::::::");
       
        pushZeroAtEnd(arr);
        int[] zot = {1,0,2,0,1,1,0,2,0,1,0,0,1,1,2,2,1,1,0};
        printArray(arr);
        System.out.println("::::::::::::::::Before doing final operations::::::::::");
        sortZeroOneTwo(zot);                    // 21. Sort zero, One and two in ascending order.
        int[] maj = {1,4,6,2,7,3,4,5,3,4,2,3,4,3,4,4,3,4,4,4,2,4,4,4,2,3,4,4,4,3,4};
        int[] prices = {7,3,7,2,4,9,12};
        int[] nums = {3,4,-1,1};
        List<String> str = Arrays.asList("6", "31415926535897932384626433832795","1","3","10","3","5","546732325452","2353235","346352235465765736234241242343253464","24356908645345776788787","9787768767623");
        majorityElementInArray(maj);
        removeDuplicateFromSortedArray();
        bestTimeToBuyStock(prices);
        numberOfZeroFilledSubArray();
        increasingTrippletesSequence(prices);
        firstMissingPositive(nums);
        searchElementArray(arr);
        findMinNMaxArray(arr);
        sortStringInAscending(str);



    }
    static void pushZeroAtEnd(int[] arr){
        int counter = 0;
        for(int n : arr){
            if(n !=0 ){
                arr[counter++] = n;
            }
        }
        while (counter<arr.length) {
            arr[counter++] = 0;
            
        }
        printArray(arr);
    }
    static void sortZeroOneTwo(int[] arr){
        int low = 0, mid=0, high=arr.length-1;
        while(mid<=high){
            switch (arr[mid]) {
                case 0:
                    swap(arr, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high--);
                    break;
            }
        }
        printArray(arr);
    }
    static void majorityElementInArray(int[] majority){
        int count = 1, candidate = majority[0];
        for(int i=1;i<majority.length;i++){
            if(candidate == majority[i]){
                count++;
            }else{
                count--;
            }
            if(count==0){
                candidate = majority[i];
                count = 1;
            }
        }
        count=0;
        for(int n: majority){
            if(candidate == n){
                count++;
            }
        }if(count>majority.length/2){
            System.out.println(candidate);
        }else{
            System.out.println("Nothing is majority");
        }
    }
    static void bestTimeToBuyStock(int[] arr){
        int minProfit = arr[0];
        int maxProfit = 0;
        for(int i=1;i<arr.length;i++){
            minProfit = Math.min(minProfit, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i]-minProfit);
                        
        }
        if(maxProfit<-1){
            System.out.println("Loss in buying stock");
        }else{
            System.out.println(maxProfit);
        }

    }
    static void firstMissingPositive(int[] array){
        int n = array.length;
        int min = 1;
        Arrays.sort(array);
        for(int i=0;i<n;i++){
            if(array[i] > min){
                break;
            }
            if(array[i] == min){
                min = min+1;
            }

        }
        System.out.println("first missing positive "+min);
    }
    static void increasingTrippletesSequence(int[] nums){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int n: nums){
            if(n <= first){
                first = n;
            }else if(n <= second){
                second = n;
            }else{
                System.out.println("Tripllets exists into an array");
            }
        }
    }
    static void sortStringInAscending(List<String> str){
        str.sort(new Comparator<String>() {
            
            public int compare(String s1, String s2){
                if(s1.length() != s2.length()){
                    return Integer.compare(s1.length(), s2.length());
                }else{
                    return s1.compareTo(s1);
                }
            }
        });
        printStringArray(str);
    }


    static void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    static void printArray(int[] arr){
        for(int n: arr){
            System.out.print(n+" ");
        }
        System.out.println();
    }
    static void printStringArray(List<String> stringArray){
        for(String str : stringArray){
            System.out.print(str+" ");
        }
    }

}
