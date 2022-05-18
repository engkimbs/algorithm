import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {

    private static char[][] numberToAlphabet = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits, int beginIndex) {
        if(beginIndex >= digits.length())
            return new ArrayList<>();

        List<String> result = new ArrayList<>();

        int digit = digits.charAt(beginIndex) - '0';
        for(int i=0; i<numberToAlphabet[digit].length; ++i) {
            List<String> subResult = letterCombinations(digits, beginIndex+1);
            String alphabet = String.valueOf(numberToAlphabet[digit][i]);
            if(subResult.size() == 0)
                result.add(alphabet);

            for(String token : subResult) {
                String newToken = alphabet + token;
                result.add(newToken);
            }
        }

        return result;
    };

    public static List<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0);
    }

    public static void main(String[] args) {
        String digits = "";
        System.out.println(letterCombinations(digits));
    }
}