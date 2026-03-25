package recursion;

public class SumOfN {

    public static void main(String[] args) {
        int n = 5;
        int result = sumOfN(n);
        int resultIterative = sumOfNIterative(n);
        System.out.println("Bruteforce approach:"+resultIterative);
        System.out.println("The sum of the first " + n + " natural numbers is: " + result);
    }
    public static int sumOfN(int n){

        if(n==1){
            return 1;
        }
        return n + sumOfN(n-1);
    }
    public static int sumOfNIterative(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }
}
