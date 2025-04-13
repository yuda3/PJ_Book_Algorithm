package LeetCode.ease;

/**
 * This class provides a method to find and print the indices of two numbers in an array
 * that add up to a specific target sum.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        printIndicesForTargetSum(nums, target);
    }

    private static void printIndicesForTargetSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.printf("Indices: %d and %d%n", i, j);
                }
            }
        }
    }
}
