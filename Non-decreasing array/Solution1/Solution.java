/*
    Time Complexity - O(N^2)
    Space Complexity - O(1)

    where N is the size of the array.
*/

public class Solution {
	public static boolean isNonDecreasing(int arr[], int n) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static boolean isPossible(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int oldVal = arr[i];

			if (i > 0) {
				arr[i] = arr[i - 1];
			} else {
				arr[i] = Integer.MIN_VALUE;
			}

			if (isNonDecreasing(arr, n)) {
				return true;
			}

			arr[i] = oldVal;
		}

		return false;

	}

}
