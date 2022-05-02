import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        String s = "abcdeafbdgcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int result = 1;
        Map<Character, Integer> lastIndexOfEachCharacterMap = new HashMap<>();
        for(int left=0, right=0; right<s.length(); ++right) {
            Character c = s.charAt(right);
            if(lastIndexOfEachCharacterMap.containsKey(s.charAt(right))) {
                if(lastIndexOfEachCharacterMap.get(c) >= left) {
                    left = lastIndexOfEachCharacterMap.get(c) + 1;
                }
            }
            result = Math.max(result, right - left + 1);
            lastIndexOfEachCharacterMap.put(c, right);
        }

        return result;
    }
}
