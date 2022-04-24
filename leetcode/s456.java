import java.lang.annotation.Retention;
import java.util.Arrays;

/**
 * S456
 */
public class S456 {

    public static void main(String[] args) {
        int nums[] = { 1, 5, 11, 5 };

        // boolean canPartition = canPartition(nums);
        // System.out.println("canPartition:" + canPartition);
        System.out.println("canPartition:" + canPartition(1, 2, new int[] { 1,2 }));
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int i : nums) {
            sum += i;
            maxNum = Math.max(maxNum, i);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];

        dp[0][0] = dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] | dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static boolean canPartition(int n1, int n2, int[] nums) {
        int sum = n1 + n2;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / 2 - Math.min(n1, n2);
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        dp[0][0] = dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] | dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
