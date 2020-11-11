/*
 * Time Complexity - O(N*K) Space Complexity - O(1)
 * 
 * where N is the size of the given array and K is the window length.
 */
public class Solution {
	public static int[] firstNegative(int arr[], int n, int k) {
		int ans[] = new int[n - k + 1];
		int idx = 0;

		// Traverse for every possible window
		for (int i = 0; i < n - k + 1; i++) {
			boolean found = false;

			for (int j = i; j < i + k; j++) {
				if (arr[j] < 0) {
					found = true;
					ans[idx++] = arr[j];
					break;
				}
			}

			if (found == false) {
				ans[idx++] = 0;
			}
		}

		return ans;
	}
}
