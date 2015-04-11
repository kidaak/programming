package java_core_demo;

public class MathTest {
	private static void sqrt() {
		double d = -9.0;
		System.out.println(Math.sqrt(d));
	}

	private static void plusMinus() {
		int result = 6 / 2 * 3;
		System.out.println(result);
	}

	private static void output() {
		int i = 1, j = 1;
		try {
			i++;
			j--;
			if (i == j)
				i++;
		} catch (ArithmeticException e) {
			System.out.println(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(1);
		} catch (Exception e) {
			System.out.println(2);
		} finally {
			System.out.println(3);
		}
		System.out.println(4);
	}

	private static void shiftBit() {
		int i = 15;
		int j = i >> 2;
		System.out.println(j);
	}

	private static void round() {
		double d = Math.round(2.5 + Math.random());
		System.out.println(d);
	}

	private static void devide() {
		int p = 3, q = 1, sum = 0;
		while (p <= 10) {
			sum += p % q;
			p++;
			++q;
		}
		System.out.println(sum);
	}

	private static void calculate() {
		System.out.println(14 ^ 23);
	}

	private static void sum() {
		int sum = 0, p = 1;
		for (int count = 1; count <= 50; count++) {
			sum += p;
			p *= 2;
		}
		System.out.println(sum);
	}

	public static void main(String args[]) {
		// sqrt();
		// plusMinus();
		// output();
		// shiftBit();
		// round();
		// devide();
		// calculate();
		// sum();
		String s = "raidua";

		System.out.println(s.lastIndexOf('a', 2));
	}
}
