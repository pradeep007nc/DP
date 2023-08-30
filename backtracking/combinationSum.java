package backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    public List<List<Integer>> combSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, target, curr, ans, 0);
        return ans;
    }

    private void backtrack(
            int[] candidates,
            int target,
            List<Integer> curr,
            List<List<Integer>> ans,
            int index
    ) {
        if (target == 0) ans.add(new ArrayList<>(curr));
        else if (target < 0 || index >= candidates.length) return;
        else {
            curr.add(candidates[index]);
            backtrack(candidates, target-candidates[index], curr, ans, index);
            curr.remove(curr.get(curr.size()-1));
            backtrack(candidates, target, curr, ans, index+1);
        }
    }


    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        // Scan from left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        // Scan from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, left + right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return maxLength;
    }

}
