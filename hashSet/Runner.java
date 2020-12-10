import java.util.Scanner;
public class Runner {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		HashSet obj = new HashSet();
		int queries = s.nextInt();

		while (queries-- > 0) {
			int queryType = s.nextInt(), value = s.nextInt();
			switch (queryType) {
			case 1:
				obj.add(value);
				break;
			case 2:
				if (obj.contains(value) == true) {
					System.out.println("True");
				} else {
					System.out.println("False");
				}
				break;
			case 3:
				System.out.println(obj.removeElement(value));
				break;
			}
		}

	}

}