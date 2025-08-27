package arrays;

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
        majorityElementInArray(maj);
        removeDuplicateFromSortedArray();
        bestTimeToBuyStock(prices);
        numberOfZeroFilledSubArray();
        increasingTrippletesSequence();
        firstMissingPositive();
        searchElementArray(arr);
        findMinNMaxArray(arr);



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


}
