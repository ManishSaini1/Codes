
/*
Time Complexity: O(N)
Space Complexity: O(1)

Where N is the size of array/list ARR.
*/
public class Solution {

	public static int findMajority(int n, int[] arr) {
		// Keeping track of majority element if it exists
		int majorityElement = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			/*
			 * If count becomes 0, set current element as a possible candidate for majority
			 * element, reset count to 1 and continue iterating
			 */
			if (count == 0) {
				majorityElement = arr[i];
				count = 1;
				continue;
			}

			if (arr[i] == majorityElement) {
				count++;
			} else {
				count--;
			}
		}

		count = 0;

		// Checking if majorityElement occurs more than n/2 times
		for (int i = 0; i < n; i++) {
			if (arr[i] == majorityElement) {
				count++;
			}
		}

		if (count > n / 2) {
			return majorityElement;
		}

		// If no majority element found, return -1
		return -1;
	}

}
