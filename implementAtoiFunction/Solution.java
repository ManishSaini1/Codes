/*
Time Complexity: O(n)
Space Complexity: O(1)

Where 'n' is the length of the string
*/

public class Solution {

	public static int atoi(String str) {
		boolean isNegative = false;
		// Check Negative
		if (str.charAt(0) == '-') {
			isNegative = true;
		}
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				// If the charecter is a digit
				int digit = (char) str.charAt(i) - '0';
				number = number * 10 + digit;
			}
		}
		if (isNegative) {
			number *= -1;
		}
		return number;
	}

}
