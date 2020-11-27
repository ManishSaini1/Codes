/*
Time complexity: O(n)
Space complexity: O(1)

Where N is the total number of elements in the array.
*/
public class Solution {

	public static int findSecondLargest(int n, int[] arr) {
		int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			// Find largest and second largest element simultaneously.
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			}

			// If an element is smaller than largest and larger than second largest.
			else if (arr[i] > secondLargest && arr[i] != largest) {
				secondLargest = arr[i];
			}
		}
		if (secondLargest != Integer.MIN_VALUE) {
			return secondLargest;
		} else {
			return -1;
		}
	}

}