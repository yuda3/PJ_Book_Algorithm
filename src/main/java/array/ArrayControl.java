package array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayControl {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{10, 20, 30, 11})));
    }

    private static int[] solution(int[] arr){
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
