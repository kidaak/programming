package java_core_demo;

public class ExceptionTest {
	private static void aMethod() throws Exception {
		try {
			throw new Exception();
		} finally {
			System.out.print("finally ");
		}
	}

	private static void throwit() {
		System.out.print("throwit ");
		throw new RuntimeException();
	}

	private static void throwError() {
		try {
			badMethod();
			System.out.print("A");
		} catch (Exception ex) {
			System.out.print("B");
		} finally {
			System.out.print("C");
		}
		System.out.print("D");
	}

	private static void badMethod() {
		throw new Error();
	}

	private static void returnInTry() {
		try {
			return;
		} finally {
			System.out.println("Finally");
		}
	}

	public static void main(String args[]) {
		// try {
		// aMethod();
		// } catch (Exception e) {
		// System.out.print("exception ");
		// }
		// System.out.print("finished");

		// try {
		// System.out.print("hello ");
		// throwit();
		// } catch (Exception re) {
		// System.out.print("caught ");
		// } finally {
		// System.out.print("finally ");
		// }
		// System.out.println("after ");
		// throwError();
		returnInTry();
	}
}
