/*
Time Complexity: O(NlogN)
Space Complexity: O(1)

Where N is the size of the array.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static ArrayList<Integer> findDuplicates(int[] arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {

			// If two consecutive elements are same, then print them.
			if (arr[i] == arr[i + 1]) {
				ans.add(arr[i]);
				while (i < n - 1 && arr[i] == arr[i + 1]) {
					i++;
				}
			}
		}

		return ans;
	}
}