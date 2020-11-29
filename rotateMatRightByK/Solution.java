/*
Time Complexity: O(N*M)
Space Complexity: O(1)
Where N and M denote the number of rows and columns 
of the given matrix.
*/

public class Solution {
	public static void rotateRightByK(int temp[], int k) {
		// reverse all the elements
		int i = 0, j = temp.length - 1;
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;
		}

		// Reversing first k elements
		i = 0;
		j = k - 1;
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;

		}
		i = k;
		j = temp.length - 1;

		// Reversing rest n-k elements
		while (i < j) {
			int element = temp[i];
			temp[i] = temp[j];
			temp[j] = element;
			i++;
			j--;

		}

	}

	public static int[][] rotateMatRight(int[][] mat, int n, int m, int k) {

		int result[][] = new int[n][m];
		int resultIndex = 0;

		// Calculating effective rotations
		k = k % m;

		for (int i = 0; i < n; i++) {
			rotateRightByK(mat[i], k);

			// Append row i to result after rotation
			result[resultIndex++] = mat[i];
		}

		return result;

	}

}
