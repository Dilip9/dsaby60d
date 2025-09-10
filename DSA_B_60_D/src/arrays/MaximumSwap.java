package arrays;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 2736;
        maximumSwap(num);
    }
    public static void maximumSwap(int num){
        char[] digits = Integer.toString(num).toCharArray();
        int[] last = new int[10];


        // Step 1. Record last occurence of each digit;
        for(int i = 0; i<digits.length;i++){
            last[digits[i] - '0'] = i;
        }
        // Step2: Try to find a larger digit to swap with current.
        for(int i=0;i<digits.length;i++){
            for(int d=9; d>digits[i]-'0'; d--){
                if(last[i]>i){
                    //swap 
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    // return Integer.parseInt(new String(digits));
                    System.out.println(Integer.parseInt(new String(digits)));
                }
            }
        }
        System.out.println(num);
    }
}
