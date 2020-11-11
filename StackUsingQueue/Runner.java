import java.util.Scanner;

public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Stack st = new Stack();
		int q = s.nextInt();
		while (q > 0) {
			int choice, input;
			choice = s.nextInt();
			switch (choice) {
			case 1:
				input = s.nextInt();
				st.push(input);
				break;
			case 2:
				System.out.println(st.pop());
				break;
			case 3:
				System.out.println(st.top());
				break;
			case 4:
				System.out.println(st.getSize());
				break;
			default:
				System.out.println(st.isEmpty());
				break;

			}
			q--;
		}
	}
}
