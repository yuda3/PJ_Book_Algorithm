package array;

import java.util.Arrays;

public class DontUseSortMethod {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        long start = System.currentTimeMillis();
        int[] bubble = bubbleSort(arr);
        long end = System.currentTimeMillis();

        System.out.println("Bubble sort time: " + (end - start));
        start = System.currentTimeMillis();
        int[]sort = doSort(arr);
        end = System.currentTimeMillis();

        System.out.println("Sort time: " + (end - start));

        System.out.println(Arrays.equals(bubble,sort));

    }

    private static int[] doSort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    private static int[] bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return null;
    }

}
