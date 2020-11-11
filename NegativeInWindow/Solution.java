/*
    Time Complexity - O(N)
    Space Complexity - O(1)

    where N is the size of the given array
*/

public class Solution {
	public static int[] firstNegative(int[] arr, int n, int k) {
		int ans[] = new int[n - k + 1];
		int idx = 0;

		int firstNegIndex = 0;

		// Traversing for every window's end
		for (int end = k - 1; end < n; end++) {

			// Move the pointer till its out of the window
			// Or until we found a negative element
			while (firstNegIndex < end && (firstNegIndex <= end - k || arr[firstNegIndex] >= 0)) {
				firstNegIndex++;
			}

			// If we found a negative
			if (arr[firstNegIndex] < 0) {
				ans[idx++] = arr[firstNegIndex];
			} else {
				ans[idx++] = 0;
			}
		}
		return ans;
	}

}
