package recursion;

import java.math.BigInteger;

import static recursion.SumOfN.sumOfN;

public class BasicRecursion {
    public static void main(String[] args) {
        int n = 10;
        int power = 5;
        System.out.println("Sum of N Number: "+sumOfN(n));
        System.out.println("Factorial of N number:::"+factorial(n));
        //System.out.println("Fibonacci of N number::::"+fibonacci(n));
        long result = powerOfNumber(n,power);
        System.out.println(n+" raised to the power of "+power+" is: "+result);
    }

    public static long factorial(int n){
        // Base case
        if(n==0 || n ==1){
            return 1;
        }
        // recursion case
        return n*factorial(n-1);
    }
    public static long fibonacci(int n){
        // Base case
        if(n<0){
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        // recursion case
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static Long powerOfNumber(int base, int exponent){
        // Base case
        if(exponent<0){
            throw new IllegalArgumentException("Exponent must be a non-negative integer.");
        }
        if(exponent == 0){
            return 1L;
        }
        if(exponent == 1){
            return (long) base;
        }

        // Recursion case
        return base * powerOfNumber(base, exponent-1);
    }
}
