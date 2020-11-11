/*
Time Complexity - O(N*logN)
Space Complexity - O(N)

where N is the size of the given array.
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static int distinctLeft(int arr[], int n, int k) {
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<>();
//		skip last k elements
		for (int i = 0; i < n - k; i++) {
			set.add(arr[i]);
		}
		return set.size();
	}

}