package java_core_demo;

public class OutputTest {
	private static void predictArrayValue() {
		int A[];
		int i = 0;
		A = new int[4];
		while (i < 4) {
			A[i] = 10;
			i = i + 1;
		}
		System.out.println(A[3]);
	}

	public static void main(String args[]) {
		predictArrayValue();
	}
}
