package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        int coverCnt = N/2;
        // 안쪽 껍질로 갈수록 cover + 1
        for(int cover=0; cover<coverCnt; ++cover) {
            for(int i=0; i<N-1-cover*2; ++i) {
                int temp = matrix[(N-1-cover)-i][cover];
                matrix[(N-1-cover)-i][cover] = matrix[N-1-cover][N-1-cover-i];
                matrix[N-1-cover][N-1-cover-i] = matrix[i+cover][N-1-cover];
                matrix[i+cover][N-1-cover] = matrix[cover][i+cover];
                matrix[cover][i+cover] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//        int[][] matrix = {
//                {5, 1, 9, 11},
//                {2, 4, 8, 10},
//                {13, 3, 6, 7},
//                {15, 14, 12, 16}
//        };
        rotate(matrix);

        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);
    }
}
