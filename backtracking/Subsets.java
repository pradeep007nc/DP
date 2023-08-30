package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> sub(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backTrack(nums, 0, ans, subset);
        return ans;
    }

    public void backTrack(int[] nums,
                          int start,
                          List<List<Integer>> ans,
                          List<Integer> subset
    ){

        if(start >= nums.length){
            ans.add(new ArrayList<>(subset));
        }else{
            subset.add(nums[start]);
            backTrack(nums, start+1, ans, subset);
            subset.remove(subset.size()-1);
            backTrack(nums, start+1, ans, subset);
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
