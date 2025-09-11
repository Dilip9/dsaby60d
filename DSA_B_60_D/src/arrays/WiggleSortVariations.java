package arrays;

public class WiggleSortVariations {
    public static void main(String[] args) {
        int[] num = {3,5,2,1,6,4};
        wiggleSortI(num);
        wiggleSortII(nums);
    }
    public static void wiggleSortI(int[] num){
        for(int i = 0;i<num.length-1;i++){
            if((i%2==0 && num[i]<num[i+1]) || (i%2==1 && num[i]>num[i+1])){
                // swap 
                int temp = num[i];
                num[i] = num[i+1];
                num[i+1] = temp;
            }
        }
        show(num);
    }

    public static void show(int[] num){
        for(int n : num){
            System.out.print(n+" ");
        }
        System.out.println(" ");
    }
}
