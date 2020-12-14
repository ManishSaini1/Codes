/*
    Time Complexity: O(N * sqrt(M) + M )
    Space complexity: O(M)
    
    Where M denotes the largest number in the array, N is the size of the given array.

*/
public class Solution {

	public static int maxGCDPair(int[] arr, int n) {
		int m = 0;
		// finding maximum element
		for (int i = 0; i < n; i++) {
			m = Math.max(m, arr[i]);
		}

		int cnt[] = new int[m + 1];

		for (int i = 0; i < n; i++) {
			// calculating divisors of an element
			for (int d = 1; d <= Math.sqrt(arr[i]); d++) {
				if (arr[i] % d == 0) {
					cnt[d]++;
					if ((arr[i] / d) != d) {
						cnt[arr[i] / d]++;
					}
				}
			}
		}

		for (int i = m; i > 0; i--) {
			if (cnt[i] > 1) {
				// i is a divisor of two or more elements
				return i;
			}
		}
		return 1;
	}
}