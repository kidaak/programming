package java_core_demo;

public class PrimitiveTypeTest {
	private static void floatTest() {
		try {
			Float f1 = new Float("3.0");
			int x = f1.intValue();
			byte b = f1.byteValue();
			double d = f1.doubleValue();
			System.out.println(x + b + d);
		} catch (NumberFormatException e) {
			System.out.println("bad number");
		}
	}

	private static double castPrimitive(byte x, double y) {
		return (short) x / y * 2;
	}

	private static void testArray() {
		for (int i = 0; i < 2; i++) {
			for (int j = 2; j >= 0; j--) {
				if (i == j)
					break;
				System.out.println("i=" + i + " j=" + j);
			}
		}
	}

	public static void main(String[] args) {
		// floatTest();
		testArray();
	}
}
