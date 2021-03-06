package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LarrayArray {

    public static String larrysArray(int[] A) {
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        int[] s = list.stream().mapToInt(Integer::intValue).toArray();
        int cnt = 0;
        String result = "";

        for(int i = 0; i < A.length-1; i++) {
            for(int j = i+1; j < A.length; j++) {
                if(A[i]>A[j]) {
                    cnt++;
                }
            }
        }

        if(cnt % 2 == 0) {
            result = "YES";
        } else {
            result = "NO";
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 6, 1, 7 , 5};
        System.out.println(larrysArray(arr));
    }
}
