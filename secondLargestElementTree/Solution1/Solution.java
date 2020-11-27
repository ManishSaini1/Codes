 /*
Time complexity: O(n)
Space complexity: O(1)

Where N is the total number of elements in the array.
*/
public class Solution {

	public static int findSecondLargest(int n, int[] arr) {
		int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

		// Find the largest element.
		for (int i = 0; i < n; i++) {
			largest = Math.max(largest, arr[i]);
		}

		for (int i = 0; i < n; i++) {
			// If the element is not equal to first largest element.
			if (arr[i] != largest) {
				secondLargest = Math.max(secondLargest, arr[i]);
			}
		}
		if (secondLargest != Integer.MIN_VALUE) {
			return secondLargest;
		} else {
			return -1;
		}
	}


}