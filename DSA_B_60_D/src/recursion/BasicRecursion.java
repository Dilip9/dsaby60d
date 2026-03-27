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
        long gcdResult = gcd(n,power);
        System.out.println("GCD of "+n+" and "+power+" is: "+gcdResult);
        long lcmResult = lcm(n,power);
        System.out.println("LCM of "+n+" and "+power+" is: "+lcmResult);
        String str = "Hello World";;
        String reversedStr = reverseString(str);
        System.out.println("Reversed String: " + reversedStr);
        System.out.println(" Reverse String with in-place reversal"+ reverseStringInPlace(str));
        System.out.println(" Reverse String with in-place reversal recursive "+ reverseStringInPlaceRecursive(str,0,str.length()-1));
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


    public static int gcd(int a, int b){
        // base case
        if(b == 0){
            return a;
        }if(a == 0) {
            return b;
        }
        // recursion case
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        // base case
        if(a == 0){
            return 0;
        }
        if(b == 0){
            return 0;
        }
        return (a*b)/gcd(a,b);
    }

    public static String reverseString(String str){
        // base case
        if(str == null || str.length() == 1){
            return str;
        }
        return reverseString(str.substring(1))+str.charAt(0);
    }

    public static String reverseStringInPlace(String str){
        int low = 0;
        int high = str.length() - 1;
        while(low< high){
            char temp = str.charAt(low);
            str = str.substring(0, low)+str.charAt(high)+str.substring(low+1, high)+temp+str.substring(high+1);
            low++;
            high--;
        }
        return str;
    }
    public static String reverseStringInPlaceRecursive(String str, int low, int high) {
        // base case
        char[] charArray = str.toCharArray();
        while (low < high) {
            char temp = charArray[low];
            charArray[low] = charArray[high];
            charArray[high] = temp;
            low++;
            high--;
        }
        return str;
    }
}
