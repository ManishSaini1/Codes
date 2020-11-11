
/*
Time Complexity : O(logN)
Space Complexity : O(logN)
where N represents which number of the sequence we have to find out.
*/
public class Solution {

	static int M = (int) (Math.pow(10, 9) + 7);

	public static void multiply(long matrix1[][], long matrix2[][]) {
		long x1 = (matrix1[0][0] * matrix2[0][0]) % M;
		long x2 = (matrix1[0][1] * matrix2[1][0]) % M;

		long y1 = (matrix1[0][0] * matrix2[0][1]) % M;
		long y2 = (matrix1[0][1] * matrix2[1][1]) % M;

		long z1 = (matrix1[1][0] * matrix2[0][0]) % M;
		long z2 = (matrix1[1][1] * matrix2[1][0]) % M;

		long w1 = (matrix1[1][0] * matrix2[0][1]) % M;
		long w2 = (matrix1[1][1] * matrix2[1][1]) % M;

		long x = (x1 + x2) % M;
		long y = (y1 + y2) % M;
		long z = (z1 + z2) % M;
		long w = (w1 + w2) % M;

		matrix1[0][0] = x;
		matrix1[0][1] = y;
		matrix1[1][0] = z;
		matrix1[1][1] = w;
	}

	public static void multiplyTwoMatrix(long[][] matrix1, long[] arr) {
		long x1 = (matrix1[0][0] * arr[0]) % M;
		long x2 = (matrix1[0][1] * arr[1]) % M;

		long y1 = (matrix1[1][0] * arr[0]) % M;
		long y2 = (matrix1[1][1] * arr[1]) % M;

		long x = (x1 + x2) % M;
		long y = (y1 + y2) % M;

		arr[0] = x;
		arr[1] = y;
	}

	public static void power(long[][] matrix1, long n) {
		if (n == 0 || n == 1) {
			return;
		}

		long matrix2[][] = new long[2][0];

		matrix2[0][0] = 1;
		matrix2[0][1] = 1;
		matrix2[1][0] = 1;
		matrix2[1][1] = 0;

		power(matrix1, n / 2);

		multiply(matrix1, matrix1);

		if (n % 2 != 0) {
			multiply(matrix1, matrix2);
		}
	}

	public static int fibonacci(int x, int y, long n) {
		if (n == 1) {
			return (int) ((x + M) % M);
		}

		if (n == 2) {
			return (int) ((y + M) % M);
		}

		n--;

		long matrix1[][] = new long[2][0];

		matrix1[0][0] = 1;
		matrix1[0][1] = 1;
		matrix1[1][0] = 1;
		matrix1[1][1] = 0;

		power(matrix1, n - 1);

		long arr[] = new long[2];

		arr[0] = y;
		arr[1] = x;

		// Multiplying the (N-2)th power of [[1,1][1,0]] to [Y,X]
		multiplyTwoMatrix(matrix1, arr);

		return (int) ((arr[0] + M) % M);
	}
}
