package backtracking;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class optimalPartitionString {
    public int partitionString(String str){
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (char ch: str.toCharArray()){
            if (set.contains(ch)){
                result++;
                set.clear();
            }
            set.add(ch);
        }
        if (!set.isEmpty()){
            result++;
        }
        return result;
    }

}
