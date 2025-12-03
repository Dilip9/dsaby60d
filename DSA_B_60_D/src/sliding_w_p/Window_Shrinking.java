public class Window_Shrinking{
    public static void main(String[] args){

        /**
         * Minimum Window Substring (Shrinking Window) Classic Leetcode hard Problem
         *  **/
        minWindow("ADOBECODEBANC", "ABC");
    }

    public static void minWindow(String s, String t){
        int[] freq = new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int required = t.length();
        int left = 0, minLength = Integer.MAX_VALUE, start =0;
        for(int right =0; right < s.length(); right++){
            char c = s.charAt(right);
            if(freq[c]-- > 0){
                required--;
            }

            while(required == 0){
                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    start = left;
                }
                if(++freq[s.charAt(left)] > 0){
                    required++;
                }
                left++;
            }
        }
        //return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
        System.out.println(minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength));
    }



}