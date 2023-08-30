package prac;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortedSum {

    public static void main(String[] args) {
        System.out.println(sortedSum(new ArrayList<>(List.of(9, 5, 8))));
    }

    public static int sortedSum(List<Integer> a) {
        // Write your code here
        int count;
        int ans = 0;
        int length = a.size();
        int iter = 1;

        for(int i=0;i<length;i++){
            bubbleSort(a, i);
            count = 0;
            iter = 1;
            for(int j=0;j<=i;j++){
                count += (iter++ * a.get(j));
            }
            ans += (count % (int)(Math.pow(10, 9)+7));
        }

        return ans;
    }

    public static void bubbleSort(List<Integer> data, int range){
        boolean flag;
        for(int i=0;i<range;i++){
            flag = false;
            for(int j=i;j<range;j++){
                if(data.get(j) > data.get(j+1)){
                    Collections.swap(data, j, j+1);
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
    }
}
