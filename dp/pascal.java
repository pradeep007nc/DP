package dp;

import java.util.ArrayList;
import java.util.List;

public class pascal {

    public static void main(String[] args) {
        pascal pascal = new pascal();
        long startTime = System.currentTimeMillis();
        pascal.generatePascalIter(1000);
        long endTime =  System.currentTimeMillis();
        System.out.println(endTime-startTime + "ms is the time taken");
    }

    public List<List<Integer>> generatePascalIter(int n){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for (int i=1;i<n;i++){
            List<Integer> newRow = new ArrayList<>();
            List<Integer> prevRow = ans.get(i-1);
            newRow.add(1);
            for (int j=1;j<i;j++){
                int sum = prevRow.get(j-1) + prevRow.get(j);
                newRow.add(sum);
            }
            newRow.add(1);
            ans.add(newRow);
        }
        return ans;
    }

    public List<List<Integer>> generatePascalRecurse(int n){
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0)
            return ans;
        generateRows(ans, n);
        return ans;
    }

    public void generateRows(
            List<List<Integer>> ans,
            int n
    ){
        if (n == 1){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            ans.add(row);
            return;
        }
        generateRows(ans, n-1);
        List<Integer> prevRow = ans.get(n-2);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i=1;i<prevRow.size();i++){
            int sum = prevRow.get(i-1) + prevRow.get(i);
            newRow.add(sum);
        }
        newRow.add(1);
        ans.add(newRow);
    }
}
