package maxSizeRectangle;

public class Solution2 {
	public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int N, int M) {
		// If matrix is empty, return 0.
		if (mat.length == 0)
			return 0;
		int left[] = new int[M], right[] = new int[M], height[] = new int[M];
		// Function signature: void fill_n(iterator begin, int n, type value);
		fill_n(left, M, 0);
		fill_n(right, M, M);
		fill_n(height, M, 0);
		int maxArea = 0;
		for (int i = 0; i < N; i++) {
			// At each row, initialise its leftBoundary to 0 and rightBoundary to mat-1.
			int curLeft = 0, curRight = M;
			for (int j = 0; j < M; j++) {

				if (mat[i][j] == 1) {
					height[j]++;
				}

				else {
					height[j] = 0;
				}

			}

			// Compute left boundary from left to right.
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == 1) {
					left[j] = Math.max(left[j], curLeft);
				}

				else {
					// Left boundary will be atleast j+1 for all matrix elements ahead of index j in
					// this row.
					left[j] = 0;
					curLeft = j + 1;
				}

			}

			// Compute right boundary from right to left.
			for (int j = M - 1; j >= 0; j--) {
				if (mat[i][j] == 1) {
					right[j] = Math.min(right[j], curRight);
				}

				else {
					// Right boundary will be atmost j-1 for all matrix elements before index j in
					// this row.
					right[j] = M;
					curRight = j; // for next case
				}

			}

			// Compute the area of rectangle whose bottom side lies in current row.(can do
			// this from either side: left/right)
			for (int j = 0; j < M; j++) {
				maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
			}

		}

		return maxArea;
	}

	private static void fill_n(int[] arr, int n, int val) {
		for (int i = 0; i < n; i++) {
			arr[i] = val;
		}

	}

}
