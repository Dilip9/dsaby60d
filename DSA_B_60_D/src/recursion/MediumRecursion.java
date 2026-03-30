package recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class MediumRecursion {

    public static void main(String[] args) {
        // Subset of uniquie array
        int[] nums = {1, 2, 2,3,3,10};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        subsetOfUniqueArray(nums, ans, result, 0);
        System.out.println("Subset of unique array: "+result);
        int[] zaggleArr = {2,6,8,3,5,8,4,6,10,23,32,23,32};
        // sort the array then call the subset of unique array function
        int[] arr = {3,5,8};
        ArrayList<Integer> permutation = new ArrayList<>();
        getPermutation(arr, 0);
        int index = binarySearch(arr, 0, arr.length, 3);
        System.out.println(" Target element found at :"+index);
        String str = "ABC";
        getStringPermutation(str.toCharArray(), 0);
        System.out.println(" ++++ Duplicate String +++++");
        getStringPermutationII("AAB".toCharArray(), 0);


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

    public static  void getPermutation(int[] arr,  int low){

        // Base case
        if(arr.length-1 == low){
            for(int n: arr){
                System.out.print(n+" ");
            }
            System.out.println();
            return ;
        }
        //recursive function
        for(int i =low ;i<arr.length;i++) {
            swap(arr, low, i);
            //result.add(arr[low]);
            getPermutation(arr, low+1);  // recursive call
            swap(arr, low, i);  // backtrack
        }

    }
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x]= arr[y];
        arr[y]=temp;
    }

    public static int binarySearch(int[] arr, int low, int high, int target){

        // Base case
        if(low>high){
            return -1;
        }

        int mid = (low+high)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid]<target){
             return binarySearch(arr, mid+1, high, target);
        }else{
            return binarySearch(arr, low, mid-1, target);
        }
    }

    public static void getStringPermutation(char[] str, int idx){

        if(str.length == idx){
            for(char ch : str){
                System.out.print(ch+" ");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i<str.length;i++){
            swapCharacter(str, idx, i);
            getStringPermutation(str, idx+1);
            swapCharacter(str, idx, i);
        }
    }
    public static void swapCharacter(char[] chr, int x, int y){
        char temp = chr[x];
        chr[x] = chr[y];
        chr[y] = temp;
    }

    public static void getStringPermutationII(char[] chr, int idx){
        if(chr.length == idx){
            for(char ch: chr){
                System.out.print(ch+" ");
            }
            System.out.println();
            return;
        }
        HashSet<Character> used = new HashSet<>();
        for(int i = idx; i<chr.length;i++){
            if(used.contains(chr[i])){
                continue;
            }
            used.add(chr[i]);
            swapCharacter(chr, idx, i);
            getStringPermutationII(chr, idx+1);
            swapCharacter(chr, idx, i);
        }
    }
}
