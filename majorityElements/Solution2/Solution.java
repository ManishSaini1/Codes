/*
Time Complexity: O(N^2)
Space Complexity: O(1)

Where N is the size of array/list.
*/

public class Solution{
	public static int findMajority(int n, int[] arr) {
		for (int i = 0; i < n; i++) {
			int maxCount = 0;

			for (int j = 0; j < n; j++) {
				if (arr[j] == arr[i]) {
					maxCount++;
				}
			}

			/*
			 * If count of arr[i] exceeds n/2, then it is the majority element
			 */
			if (maxCount > n / 2) {
				return arr[i];
			}
		}

		// If no majority element found, return -1
		return -1;

	}

}
