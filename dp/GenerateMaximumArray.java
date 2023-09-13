package dp;

public class GenerateMaximumArray {

    public static void main(String[] args) {
        GenerateMaximumArray maximumArray = new GenerateMaximumArray();
        System.out.println(maximumArray.getMaximumGenerated(3));
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        int ans = 1;

        for (int i = 1; i <= n / 2; i++) {  // Change the loop condition
            dp[(i * 2)] = dp[i];
            if ((i * 2 + 1) <= n) {
                dp[(i * 2) + 1] = dp[i+1] + dp[i];
                ans = Math.max(ans, dp[(i * 2) + 1]);
            }
        }

        return ans;
    }
}
