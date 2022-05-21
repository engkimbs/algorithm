package leetcode;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int result = 0;
        int left=0, right = height.length-1;

        while(left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int area = (right - left)*Math.min(leftHeight, rightHeight);
            result = Math.max(result, area);

            if(leftHeight >= rightHeight) --right;
            if(leftHeight < rightHeight) ++left;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
}
