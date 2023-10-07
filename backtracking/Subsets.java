package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().sub(new int[]{1,2,3}));
    }

    public List<List<Integer>> sub(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(ans, subset, nums, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans
            , List<Integer> currList
            , int[] nums
            , int index)
    {
        ans.add(new ArrayList<>(currList));
        for(int i=index;i<nums.length;i++){
            currList.add(nums[i]);
            backtrack(ans, currList, nums, i+1);
            currList.remove(currList.size()-1);
        }
    }



//    1
//    232
//    34543
//    4567654
//    if i == 4

//    inner start with i

    public void pattern(int n){
        int count = 1;
        for(int i=1;i<=n;i++){
            int temp = i;
            int mid = count - i;
            boolean flag = true;
            for (int j=i;j<=count;j++){
                System.out.print(temp+" ");
                if (temp <= mid && flag) temp++;
                else {
                    flag = false;
                    temp--;
                }
            }
            count+=3;
            System.out.println();
        }
    }
}
