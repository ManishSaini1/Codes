
/*
    Time Complexity : O(N*M)
    Space Complexity : O(1)
    Where N is the number of rows and M is the number of columns in the given matrix.
*/

public class Solution {

	public static int getMaxPathSum(int[][] matrix) {
		int n = matrix.length, m = matrix[0].length;

		for (int row = 1; row < n; row++) {
			for (int col = 0; col < m; col++) {
				matrix[row][col] = matrix[row][col] + Math.max(matrix[row - 1][col],
						Math.max(matrix[row - 1][Math.max(0, col - 1)], matrix[row - 1][Math.min(m - 1, col + 1)]));
			}
		}

		// Get the max path sum
		int maxPathSum = Integer.MIN_VALUE;
		for (int col = 0; col < m; col++) {
			if (maxPathSum < matrix[n - 1][col]) {
				maxPathSum = matrix[n - 1][col];
			}
		}
		return maxPathSum;
	}

}
