package backtracking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinimumFallingPath {

    public static void main(String[] args) {
        int[][] data = {
                {100,-42,-46,-41},
                {31,97,10,-10},
                {-58,-51,82,89},
                {51,81,69,-51}
        };

        List<List<Integer>> daata = Stream.of(data).map(
                arr -> Arrays.stream(arr)
                        .map(num -> num * num)
                        .boxed()
                        .collect(Collectors.toList())
        ).collect(Collectors.toList());

        int[][] streamedData = daata.stream()
                        .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                                .toArray(int[][]::new);

        System.out.println(daata);

        MinimumFallingPath path = new MinimumFallingPath();
        System.out.println(path.minFallingPathSum(data));
        System.out.println(Arrays.deepToString(data));
    }

    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;

        for (int i=0;i<matrix.length;i++){
            int minIndex = i;
            int traverse = 0;
            int tempAns = 0;
            while (traverse < matrix.length){
                int temp;
                if (minIndex == 0){
                    minIndex = matrix[traverse][0] < matrix[traverse][1] ? 0 : 1;
                }else if(minIndex == matrix.length-1)
                    minIndex = matrix[traverse][matrix.length-1] < matrix[traverse][matrix.length-2] ?
                            matrix.length-1 : matrix.length-2;
                else {
                    temp = matrix[traverse][minIndex] < matrix[traverse][minIndex-1] ? minIndex : minIndex-1;
                    minIndex = matrix[traverse][temp] < matrix[traverse][minIndex+1] ? temp : minIndex+1;
                }
                tempAns += matrix[traverse][minIndex];
                traverse++;
            }
            ans = Math.min(ans, tempAns);
        }

        return ans;
    }

    public int backTrack(
            int[][] matrix,
            int traverse,
            int ans,
            int globalSum
    ) {
        if (traverse == matrix.length) {
            globalSum = Math.min(ans, globalSum);
            return ans;
        }

        int minIndex = traverse;

        ans += matrix[0][minIndex];

        while (traverse < matrix.length) {
            int temp;
            if (minIndex == 0) {
                minIndex = matrix[traverse][0] < matrix[traverse][1] ? 0 : 1;
            } else if (minIndex == matrix.length - 1)
                minIndex = matrix[traverse][matrix.length - 1] < matrix[traverse][matrix.length - 2] ?
                        matrix.length - 1 : matrix.length - 2;
            else {
                temp = matrix[traverse][minIndex] < matrix[traverse][minIndex - 1] ? minIndex : minIndex - 1;
                minIndex = matrix[traverse][temp] < matrix[traverse][minIndex + 1] ? temp : minIndex + 1;
            }
            ans += matrix[traverse][minIndex];
            traverse++;
        }

        return ans;
    }
}
