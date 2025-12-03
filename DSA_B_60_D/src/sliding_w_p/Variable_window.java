public class Variable_window {
    public static void main(String[] args){
        /**
         * Longest Substring without Repeating Characters (Variable Window)
         * **/
        lengthOfLongestSubstring("abcabcbb");

        /**
         * Longest Substring with K Distinct Characters (Variable Window)
         *
         * */
        longestSubStringWithKDistinctChars("araaci",2);
    }
    public static void lengthOfLongestSubstring(String s){
        int[] freq = new int[256];
        int left = 0, maxLen = 0;
        for(int right =0; right<s.length();right++){
            freq[s.charAt(right)]++;
            while(freq[s.charAt(right)]>1){
                freq[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println("Length of Longest Substring without repeating characters : "+maxLen);
    }

    public static void longestSubStringWithKDistinctChars(String s, int k){
        int left = 0, maxSum = 0 ;

        Map<Character, Integer> map = new HashMap<>();
        for(int right =0; right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                char ch = s.charAt(left);
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) ==0){
                    map.remove(ch);
                }
                left++;
            }
            maxSum = Math.max(maxSum, right-left+1);
        }
        System.out.println("longest substring, with K Distinct char :"+maxSum);
    }
}