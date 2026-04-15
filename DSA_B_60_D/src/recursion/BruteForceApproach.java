package recursion;

public class BruteForceApproach {

    public static void main(String[] args) {
        // count inversion in an array
        int[] arr = {1, 20, 6, 4, 5};
        int inversionCount = countInversions(arr);
        System.out.println("Number of inversions in the array: " + inversionCount);
    }
    public static int countInversions(int[] arr){
        int count = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    System.out.println("Inversion found: (" + arr[i] + ", " + arr[j] + ")");
                    count++;
                }
            }
        }
        return count;
    }
}
