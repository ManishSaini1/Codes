/*
Time complexity: O(1)
Space complexity: O(1)
*/
public class Solution {
	public static int[] swapNumber(long num1, long num2) {
		int answer[] = new int[2];

		// Edge case atleast one number is '0'
		if (num1 == 0 || num2 == 0) {
			answer[0] = (int) num2;
			answer[1] = (int) num1;
			return answer;
		}

		num1 = num1 * num2;
		num2 = (long) Math.floor(num1 / num2);
		num1 = (long) Math.floor(num1 / num2);

		answer[0] = (int) num1;
		answer[1] = (int) num2;
		return answer;
	}
}