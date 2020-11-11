 
/*
    Time Complexity : O(M*3^(N*M))
    Space Complexity : O(N)
    Where N is the number of rows and M is the number of columns in the given matrix.
*/

public class Solution {

//  x-directions and y-directions
	static int dx[] = { 1, 1, 1 };
	static int dy[] = { 0, -1, 1 };

	public static boolean isValid(int row, int col, int n, int m) {
		return (row >= 0 && col >= 0 && row < n && col < m);
	}

	public static int getMaxPathSumHelper(int row, int col, int[][] matrix, int n, int m) {

		// Base case: we are at last row
		if (row == n - 1) {
			return matrix[row][col];
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
				currPathSum = Math.max(currPathSum, getMaxPathSumHelper(nextRow, nextCol, matrix, n, m));
			}
		}
		// Include (row, col) cell into maximum path sum
		maxPathSum = matrix[row][col] + currPathSum;

		return maxPathSum;
	}

	public static int getMaxPathSum(int[][] matrix) {
		int maxPathSum = Integer.MIN_VALUE, currPathSum;

		int n = matrix.length;
		int m = matrix[0].length;

		// Explore all possible from all cell of the first row to the any cell of the
		// last row
		for (int i = 0; i < m; i++) {
			currPathSum = getMaxPathSumHelper(0, i, matrix, n, m);

			// Check, If we get better path
			if (currPathSum > maxPathSum) {
				maxPathSum = currPathSum;
			}
		}

		return maxPathSum;
	}

}
