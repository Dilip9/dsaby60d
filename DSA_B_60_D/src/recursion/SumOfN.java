package recursion;

public class SumOfN {

    public static void main(String[] args) {
        int n = 5;
        int result = sumOfN(n);
        System.out.println("The sum of the first " + n + " natural numbers is: " + result);
    }
    public static int sumOfN(int n){

        if(n==1){
            return 1;
        }
        return n + sumOfN(n-1);
    }
}
