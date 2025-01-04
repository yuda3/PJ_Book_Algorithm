package array;

import java.util.*;

public class PickTwoAndAdd {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,1,3,4,1})));
        System.out.println(Arrays.toString(solution(new int[]{5,0,2,7})));
    }

    static int[] solution(int[] arrays){
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < arrays.length; i++){
            for(int j = i + 1; j < arrays.length; j++){
                set.add(arrays[i] + arrays[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
