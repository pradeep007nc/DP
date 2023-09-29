package prac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class increasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        for(int i = 0; i < nums.length - 3; i++) {
            if ((nums[i] < nums[i + 1]) && (nums[i + 1] < nums[i + 2])) return true;
        }
        return false;
    }

    public static int minimumCoins(int n, int[] coins, Map<Integer, Integer> memo) {
        // Initialize ans to a large value
        int ans = Integer.MAX_VALUE;
        if (memo.containsKey(n))
            return memo.get(n);

        // If n is 0, no coins are needed
        if (n == 0)
            return 0;

        for (int coin : coins) {
            int sub = n - coin;
            if (sub < 0)
                continue;

            // Recursively calculate the minimum number of coins
            int subSolution = minimumCoins(sub, coins, memo);

            // Check if subSolution is a valid solution (i.e., not Integer.MAX_VALUE)
            if (subSolution != Integer.MAX_VALUE) {
                // Update ans with the minimum number of coins
                ans = Math.min(ans, subSolution + 1);
                memo.put(n, ans);
            }
        }

        return ans;
    }

    public static int minCoinsBottomUp(int n, int[] coins) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minCoinsBottomUp(3500, new int[]{1, 4, 5, 2, 9}));
    }
}
