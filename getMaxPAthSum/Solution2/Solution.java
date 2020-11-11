/*
    Time Complexity : O(N*M)
    Space Complexity : O(N*M)
    Where N is the number of rows and M is the number of columns in the given matrix.
*/

public class Solution {

//  x-directions and y-directions
	static int dx[] = { 1, 1, 1 };
	static int dy[] = { 0, -1, 1 };

	public static boolean isValid(int row, int col, int n, int m) {
		return (row >= 0 && col >= 0 && row < n && col < m);
	}

	public static int getMaxPathSumHelper(int row, int col, int[][] matrix, int[][] dp, int n, int m) {

		// Base case: we are at last row
		if (row == n - 1) {
			return matrix[row][col];
		}

		// Check whether we have already a solution or not?
		if (dp[row][col] != Integer.MIN_VALUE) {
			return dp[row][col];
		}

		int maxPathSum, currPathSum = Integer.MIN_VALUE;

		// Get the maximum path sum from (row,col) to the any cell of last row,
		// excluding (row,col) cell
		for (int i = 0; i < 3; i++) {
			// Get new cell
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];

			// Check whether new cell is a valid cell or not?
			if (isValid(nextRow, nextCol, n, m)) {
				currPathSum = Math.max(currPathSum, getMaxPathSumHelper(nextRow, nextCol, matrix, dp, n, m));
			}
		}

		// Include (row, col) cell into maximum path sum
		maxPathSum = matrix[row][col] + currPathSum;

		// Store in dp to avoid redundant calls
		dp[row][col] = maxPathSum;

		return maxPathSum;
	}

	public static int getMaxPathSum(int[][] matrix) {
		int maxPathSum = Integer.MIN_VALUE, currPathSum;

		int n = matrix.length;
		int m = matrix[0].length;

		// For storing the output of each cell so that we can avoid redundant calls
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			currPathSum = getMaxPathSumHelper(0, i, matrix, dp, n, m);
			if (currPathSum > maxPathSum) {
				maxPathSum = currPathSum;
			}
		}

		return maxPathSum;
	}

}
