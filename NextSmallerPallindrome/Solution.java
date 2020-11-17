
/*
Time Complexity: O(N)
Space Complexity: O(1)

where, N is the length of given numeric string S.
*/

public class Solution {

	public static String nextSmallerPalindrome(String S) {
		if (S.charAt(0) == '1' && S.length()==1) {
			return "0";
		}

		int n = S.length();
		// From mid position, move left and right, till you encounter S[i] != '0'.
		char arr[] = S.toCharArray();
		int mid = n / 2;
		for (int i = mid; i < n; i++) {
			int digit = arr[i] - '0';
			// If the digit is not 0, reduce it by 1.
			if (digit != 0) {
				arr[i] = arr[n - 1 - i] = (char) ((digit - 1) + '0');
				break;
			}

			// Else change digit 0 to 9.
			else {
				arr[i] = arr[n - 1 - i] = '9';
			}

		}
		// Handling 100001 types cases -> after doing above steps -> 099990 -> gets
		// converted to 99999.
		if (arr[0] == '0') {
			arr[0] = '9';
			// converting character array to string
			S = String.valueOf(arr);
			return S.substring(0, n - 1);

		} else {
			S = String.valueOf(arr);
			return S;
		}

	}

}
