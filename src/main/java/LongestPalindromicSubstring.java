public class LongestPalindromicSubstring {

    private static int left_max = 0, right_max = 0;
    private static String global_s;
    public static String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return s;

        global_s = s;
        for(int i=0; i<s.length(); ++i){
            checkPalindrome(i-1,i+1);
            checkPalindrome(i,i+1);
        }

        return s.substring(left_max, right_max+1);
    }

    public static void checkPalindrome(int left, int right){
        while(left >= 0 && right < global_s.length()){
            if(global_s.charAt(left) == global_s.charAt(right)){
                if(right_max - left_max < right - left){
                    left_max = left;
                    right_max = right;
                }
                left--;
                right++;
            }
            else
                break;
        }
    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 1)
            return true;
        int begin=0, end=s.length()-1;
        while(begin < end) {
            Character beginChar = s.charAt(begin);
            Character endChar = s.charAt(end);

            if(!beginChar.equals(endChar))
                return false;

            begin++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
