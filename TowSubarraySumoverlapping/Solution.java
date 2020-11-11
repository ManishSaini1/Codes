/*
Time Complexity: O(N)
Space Complexity: O(N)
Where N is the size of array/list ARR.
*/
public class Solution {

	public static int maxSumTwoSubarray(int[] arr, int N, int K) {
		// Initializing result sum
		int maxSum = -1000000000;
		// Array to store prefix sum
		int prefixSum[] = new int[N + 1];
		// Array to store maximum subarray sum of size K
		int dp[] = new int[N + 1];

		prefixSum[0] = 0;

		// Storing prefix sum
		for (int i = 0; i < N; i++) {
			prefixSum[i + 1] = arr[i] + prefixSum[i];
		}

		// Initializing dp[K] to the sum of first subarray of size K
		dp[K] = prefixSum[K];

		// Storing maximum subarray sum till index i
		for (int i = K + 1; i <= N; i++) {
			// Sum of subarray of size K can be easily calculated using prefix sum array
			// Set dp[i] to maximum subarray sum calculated so far
			dp[i] = Math.max(dp[i - 1], prefixSum[i] - prefixSum[i - K]);
		}

		// Looping from 2*K (to prevent overlap) to N
		for (int i = 2 * K; i <= N; i++) {
			/*
			 * If total of subarray sum with starting and ending indices (i,i+K) and maximum
			 * subarray sum at i-K index (dp[i-K]) is more than result sum then update it
			 */
			maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[i - K] + dp[i - K]);
		}

		return maxSum;

	}

}
