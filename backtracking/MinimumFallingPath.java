package backtracking;

public class MinimumFallingPath {

    public static void main(String[] args) {
        int[][] data = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        MinimumFallingPath path = new MinimumFallingPath();
        System.out.println(path.minFallingPathSum(data));
    }

    public int minFallingPathSum(int[][] matrix) {
        int ans = 0;
        for (int i=0;i<matrix.length;i++){
            int temp = i;
            for (int j=i+1;j<matrix.length;j++){
                int min = 0;

            }
        }
    }
}
