/*
Time Complexity: O(M*log(log(M)))
Space complexity: O(M)

Where M denotes the largest number in the array.
*/

public class Solution {

	public static int maxGCDPair(int[] arr, int n) {
		int m = 0;
		// finding maximum element
		for (int i = 0; i < n; i++) {
			m = Math.max(m, arr[i]);
		}

		// finding frequency of each element
		int freq[] = new int[m + 1];
		for (int i = 0; i < n; i++) {
			freq[arr[i]]++;
		}

		for (int i = m; i > 0; i--) {
			int cnt = 0;
			for (int j = i; j <= m; j += i) {
				cnt += freq[j];
			}
			if (cnt > 1) {
				// i is a divisor of two or more elements
				return i;
			}
		}
		return 1;
	}

}