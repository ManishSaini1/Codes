 /*
Time complexity: O(n*logn)
Space complexity: O(1)

Where N is the total number of elements in the array.
*/
import java.util.Arrays; 
public class Solution {
	public static int findSecondLargest(int n, int[] arr) {
		// Sort the array in ascending order.
		Arrays.sort(arr);
		for (int i = n-1; i > 0; i--) {
			// If the (i-1) element is not equal to first largest element.
			if (arr[i] != arr[i - 1]) {
				return arr[i-1];
			}
		}
		return -1;
	
	}

}