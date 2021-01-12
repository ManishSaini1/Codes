/*
Time Complexity: O(N*M)
Space Complexity: O(N*M)

Where N is the number of rows and M is the number of columns in the array.
*/

public class Solution {

	public static int findMinCost(int[][] buildings, int n, int m) {
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = 0;

		// Preprocessing dp array for first row and first column.
		for (int i = 1; i < m; i++) {
			dp[0][i] = dp[0][i - 1] + Math.abs(buildings[0][i] - buildings[0][i - 1]);
		}

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + Math.abs(buildings[i][0] - buildings[i - 1][0]);
		}
		// Finding the minimum cost of visiting each of adjacent buildings.
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				int leftCost = dp[i][j - 1] + Math.abs(buildings[i][j] - buildings[i][j - 1]);
				int topCost = dp[i - 1][j] + Math.abs(buildings[i][j] - buildings[i - 1][j]);
				int diagCost = dp[i - 1][j - 1] + Math.abs(buildings[i][j] - buildings[i - 1][j - 1]);
				dp[i][j] = Math.min(Math.min(leftCost, topCost), diagCost);

			}
		}
		// The answer will be stored at the last index.
		return dp[n - 1][m - 1];

	}

}