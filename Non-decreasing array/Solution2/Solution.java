/*
    Time Complexity - O(N)
    Space Complexity - O(1)

    where N is the size of the array.
*/
public class Solution {
	public static boolean isPossible(int[] arr, int n) {
		int start = 0, end = n - 1;

		while (start + 2 < n && arr[start] <= arr[start + 1] && arr[start + 1] <= arr[start + 2]) {
			start += 1;
		}
		while (end - 2 >= 0 && arr[end - 2] <= arr[end - 1] && arr[end - 1] <= arr[end]) {
			end -= 1;
		}

		if (end - start + 1 <= 2) {
			return true;
		}

		if (end - start + 1 >= 5) {
			return false;
		}

		return bruteForce(arr, n, start, end);

	}

	private static boolean bruteForce(int[] arr, int n, int start, int end) {
		for (int i = start; i <= end; i++) {
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

	private static boolean isNonDecreasing(int[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}

		return true;
	}

}
