/*
Time Complexity - O(N)
Space Complexity - O(K)

where N is the size of the given array
and K is the window length.
*/
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
	public static int[] firstNegative(int arr[], int n, int k) {
		int ans[] = new int[n - k + 1];
		int idx = 0;

		Queue<Integer> q = new LinkedList<>();

		// Insert first window elements
		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				q.add(i);
			}
		}

		// First window's range
		int start = 0, end = k - 1;

		// Loop for all windows
		while (end < n) {
			if (!q.isEmpty()) {
				int currIndex = q.peek();

				ans[idx++] = arr[currIndex];

				// If first element of window is negative
				if (start == currIndex) {
					// It will not be present in further windows
					q.poll();
				}
			} else {
				ans[idx++] = 0;
			}

			// Move window forward
			start++;
			end++;

			// Insert element in queue, if negative
			if (end < n && arr[end] < 0) {
				q.add(end);
			}
		}

		return ans;
	}

}
