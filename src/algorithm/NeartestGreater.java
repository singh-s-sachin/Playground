package algorithm;

public class NeartestGreater {
    /**
     * Example 1:
     * <p>
     * Input: nums = [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number.
     * The second 1's next greater number needs to search circularly, which is also 2.
     * Example 2:
     * <p>
     * Input: nums = [1,2,3,4,3]
     * Output: [2,3,4,-1,4]
     */
    public static int[] compute(int[] nums) {
        int[] response = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i != nums.length - 1 ? i + 1 : 0;
            while (nums[j] <= nums[i] && i != j) {
                j++;
                if (j >= nums.length-1) {
                    j = 0;
                }
            }
            response[i] = j == i ? -1 : nums[j];
        }
        return response;
    }
}
