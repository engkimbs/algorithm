import java.util.Arrays;

public class JumpGame2 {

    public static int[] cache;

    public static int jump(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return jump(nums, 0);
    }

    public static int jump(int[] nums, int loc) {
        if(cache[loc] != -1)
            return cache[loc];

        if(loc == nums.length -1) {
            return 0;
        }

        int minCount = nums.length - 1;
        int canJump = nums[loc];
        for(int j=1; j<=canJump; ++j) {
            int nextLoc = loc + j;
            if(nextLoc < nums.length) {
                int subMinCount = 1 + jump(nums, nextLoc);
                minCount = Math.min(minCount, subMinCount);
            }
        }

        cache[loc] = minCount;

        return minCount;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }
}
