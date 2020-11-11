/*
    Time Complexity - O(N^2)
    Space Complexity - O(N)

    where N is the size of the given array.
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static int distinctLeft(int arr[], int n, int k) {

		for (int j = 0; j < k; j++) {
			int maxIndex = -1, maxValue = -1;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > maxValue) {
					maxValue = arr[i];
					maxIndex = i;
				}
			}
			arr[maxIndex] = Integer.MIN_VALUE;
		}

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != Integer.MIN_VALUE)
				set.add(arr[i]);
		}

		return set.size();

	}

}
