package dp;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
        int[] dp = {nums[0], nums[1], 0};
        for(int i=2;i<nums.length;i++){
            dp[2] = Math.max(nums[i] +  dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return Math.max(dp[0], dp[1]);
    }
}
