package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; ++i) {
            int num = nums[i];
            if(num > 0 && num <= n) {
                set.add(num);
            }
        }

        for(int i=1; i<=n; ++i) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return n+1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }
}
