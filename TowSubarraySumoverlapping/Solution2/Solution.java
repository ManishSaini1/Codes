/*
Time Complexity: O(N*N*K)
Space Complexity: O(1)

Where N is the size of array/list ARR
and K is the given integer.
*/

public class Solution {
	public static int getSum(int arr[], int start, int end) {
		int sum = 0;

		// Calculating sum of array elements from indices start to end.
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}

		return sum;

	}

	public static int maxSumTwoSubarray(int arr[], int N, int K) {
		int maxSum = -1000000000;

		for (int i = 0; i <= N - 2 * K; i++) {
			int sum1 = getSum(arr, i, i + K);

			// Calculating sum of subarrays of length K and atleast K distance away
			for (int j = i + K; j <= N - K; j++) {
				int sum2 = getSum(arr, j, j + K);

				if (sum1 + sum2 > maxSum) {
					maxSum = sum1 + sum2;
				}

			}

		}

		return maxSum;

	}

}
