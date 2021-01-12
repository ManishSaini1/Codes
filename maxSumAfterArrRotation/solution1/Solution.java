/*
		Time Complexity: O(N^2)
		Space Complexity: O(1)

		where N is size of the array.
*/

public class Solution {
		public static long minJumps(int[] Arr, int N) {
		long s = 1;
		long maxmSum = 0;
		// Starting index.
		for (int i = 0; i < N; i++) {
			long currentSum = 0;
			// Current index in this rotated array.
			int curIndex = 0;
			for (; curIndex < N; curIndex++) {
				int origIdx = (i + curIndex) % N;
				currentSum += (s * curIndex * Arr[origIdx]);
			}

			maxmSum = Math.max(maxmSum, currentSum);
		}

		return maxmSum;
	}



}