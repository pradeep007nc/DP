package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    Map<Integer, Boolean> map = new HashMap<>();
    Map<Integer , List<Integer>> map2 = new HashMap<>();

    Map<Integer , List<Integer>> memo = new HashMap<>();

    public List<Integer> twoSum3(int target, int[] arr) {
        //base case to give a new object for parent node
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        //checking if the target is already present
        if (memo.containsKey(target)) return memo.get(target);

        //it stores the shortest array for the o/p sum
        List<Integer> shortestCombination = null;


        for (int num: arr){
            int reminder = target - num;
            List<Integer> reminderCombination = twoSum3(reminder, arr);
            if (reminderCombination != null){
                List<Integer> combination = new ArrayList<>(reminderCombination);
                combination.add(num);
                if (shortestCombination == null ||
                                combination.size() < shortestCombination.size()){
                    shortestCombination = combination;
                }
            }
        }

        memo.put(target, shortestCombination);
        return shortestCombination;
    }


    public List<Integer> twoSum2(int target, int[] arr) {
        if(map2.containsKey(target)) return map2.get(target);
        if (target < 0) return null;
        if (target == 0) {
            new ArrayList<>();
        }
        for (int num : arr) {
            if(num > 0) {
                int rem = target - num;
                List<Integer> returnList = twoSum2(rem, arr);
                map2.put(rem, returnList);
                if (returnList != null) {
                    returnList.add(num);
                    return returnList;
                }
            }
        }
        return null;
    }


    public boolean twoSum(int target, List<Integer> list){
        if(map.containsKey(target)) return map.get(target);
        if(target == 0) return true;
        if(target < 0) return false;

        for(int n: list){
            int rem = target - n;
            map.put(rem, twoSum(rem, list));
                if(map.get(rem)) return true;
        }

        return false;
    }

}
