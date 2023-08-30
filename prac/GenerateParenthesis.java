package prac;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans, "",0, 0, n);
        return ans;
    }

    public static void backtrack(
            List<String> ans,
            String currString,
            int open,
            int close,
            int max
    ){
        if (currString.length() == max * 2){
            ans.add(currString);
            return;
        }
        if(open < max)
            backtrack(ans, currString+"(", open+1, close, max);
        if(close < open)
            backtrack(ans, currString+")", open, close+1, max);
    }

}
