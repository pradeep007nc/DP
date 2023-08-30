package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class canConstructString {

    Map<String, Boolean> map = new HashMap<>();

    Map<String, Integer> map2 = new HashMap<>();

    Map<String, List<List<String>>> memo = new HashMap<>();

    public boolean canConstruct(List<String> list, String target){

        if (map.containsKey(target)) return map.get(target);
        if (target.equals("")) return true;

        for(String str: list){
            if(isPost(str, target)){
                int start = target.length() - str.length();
                map.put(target, true);
                if (canConstruct(list, target.substring(0, start))) {
                    return true;
                }
            }
        }

        map.put(target, false);
        return false;
    }
    public int canConstruct2(List<String> list, String target) {
        if (map2.containsKey(target)) return map2.get(target);
        if (target.equals("")) return 1;

        int totalCount = 0;
        for (String str : list) {
            if (isPost(str, target)) {
                int start = target.length() - str.length();
                int res = canConstruct2(list, target.substring(0, start));
                totalCount += res;
            }
        }
        map2.put(target, totalCount); // Store the count in the map for memoization
        return totalCount;
    }

    public List<List<String>> canConstruct3(List<String> list, String target) {
        List<List<String>> ans = new ArrayList<>();

        if (target.equals("")) {
            ans.add(new ArrayList<>());
            return ans;
        }

        for (String str : list) {
            if (isPost(str, target)) {
                int start = target.length() - str.length();
                List<List<String>> temp1 = canConstruct3(list, target.substring(0, start));
                for (List<String> tempList : temp1) {
                    tempList.add(str);
                    ans.add(new ArrayList<>(tempList)); // Create a new list and add it to ans
                }
            }
        }

        return ans;
    }

    private boolean isPost(String str, String target) {
        return target.endsWith(str);
    }

}
