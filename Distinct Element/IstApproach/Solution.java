
/*
Time Complexity - O(N*logN)
Space Complexity - O(1)

where N is the size of the given array.
*/
import java.util.Arrays;

public class Solution {

	public static int distinctLeft(int arr[], int n, int k) {

		Arrays.sort(arr);
		int distinctCount = 0;
		// If there is at least one element left
		if (k < n) {
			distinctCount = 1;
		}
		for (int i = 1; i < n - k; i++) {
			// Found a new element
			if (arr[i] != arr[i - 1]) {
				distinctCount++;
			}
		}

		return distinctCount;
	}

}
