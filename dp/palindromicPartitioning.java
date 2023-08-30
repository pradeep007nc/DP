package dp;

import java.util.ArrayList;
import java.util.List;

public class palindromicPartitioning {
    public static void main(String[] args) {
        palindromicPartitioning p = new palindromicPartitioning();
        System.out.println(p.partition("amma"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(ans, curr, 0, s);
        return ans;
    }

    public void backtrack(
            List<List<String>> ans,
            List<String> curr,
            int index,
            String s
    ){
        if(index == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i+1));
                backtrack(ans, curr, i+1, s);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
