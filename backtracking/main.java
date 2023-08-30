package backtracking;

import java.util.List;

public class main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        combinationSum sum = new combinationSum();
        System.out.println(sum.combSum(new int[]{1,2,3,4,5,6,7}, 70));
        long end = System.currentTimeMillis();

        System.out.println(end-start+"ms");
    }

}
