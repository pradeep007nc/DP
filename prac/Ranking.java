package prac;

import java.util.*;
import java.util.stream.Stream;

public class Ranking {
    public static void main(String[] args) {
        int[] arr1 = {100, 100, 50, 40, 40, 20, 10};
        int[] arr2 = {5, 25, 50, 120};

        List<Integer> ranked = new ArrayList<>();
        for (int value : arr1) {
            ranked.add(value);
        }

        List<Integer> player = new ArrayList<>();
        for (int value : arr2) {
            player.add(value);
        }

        System.out.println(climbingLeaderboard(ranked, player));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        int currentScore = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: ranked)
            map.merge(i, 1, Integer::sum);

        List<Integer> ans = new ArrayList<>();

        int index = ranked.size()-1;
        for(int i: player){

            currentScore += i;

            while(!map.isEmpty() && currentScore >= ranked.get(index)){
                int val = ranked.get(index);
                index -= map.get(val);
                map.remove(val);
            }

            ans.add(Math.max(map.size()+1, 1));

        }

        return ans;
    }
}
