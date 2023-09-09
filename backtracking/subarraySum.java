package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class subarraySum {
    public static void main(String[] args) {
        subarraySum sum = new subarraySum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];

        String input = sc.nextLine();

        int[] data = Stream.of(input.split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String document = "This is a document. This document contains words. Words are important in this document!";



        System.out.println(sum.subArraySum(data, target));
    }

    public List<Integer> subArraySum(int[] arr, int target){
        int left = 0;
        int right = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;

        while(right < arr.length && left < arr.length){
            if(sum == target){
                ans.add(left);
                ans.add(right);
                return ans;
            }else if(sum < target)
                sum += arr[right++];
            else
                sum -= arr[left++];
        }


        return ans;
    }
}
