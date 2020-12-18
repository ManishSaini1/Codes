/*
Time complexity: O(1)
Space complexity: O(1)
*/
public class Solution {

	public static int[] swapNumber(int num1, int num2) {
		int answer[] = new int[2];

		// Edge case when given two variable are same
		if (num1 == num2) {
			answer[0] = num1;
			answer[1] = num2;
			return answer;
		}

		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;

		answer[0] = num1;
		answer[1] = num2;
		return answer;

	}

}