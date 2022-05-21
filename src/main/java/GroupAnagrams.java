import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] key = new char[26];
            for(int i=0; i<str.length(); ++i) {
                int idx = str.charAt(i) - 'a';
                key[idx]++;
            }
            String keyStr = String.valueOf(key);
            if(!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
                map.get(keyStr).add(str);
            } else {
                map.get(keyStr).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
