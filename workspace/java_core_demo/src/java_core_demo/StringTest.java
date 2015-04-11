package java_core_demo;

public abstract class StringTest {
	private static void replaceString() {
		String a = "ABCD";
		String b = a.toLowerCase();
		b.replace('a', 'd');
		b.replace('b', 'c');
		System.out.println(b);
	}

	private static void printChar() {
		char c = 49;
		System.out.println(c);
	}

	private static void concat() {
		System.out.println("1" + new Integer(2) + 3);
	}

	private static void concat2() {
		int i1 = 5;
		int i2 = 6;
		String s1 = "7";
		System.out.println(i1 + i2 + s1);
	}

	private static void nullString() {
		String s1 = "withoutbook";
		String s2 = s1;
		s1 = null;
		System.out.println("s1:" + s1 + " s2:" + s2);
	}

	private static void subString() {
		String a = "newspaper";
		a = a.substring(5, 7);
		char b = a.charAt(1);
		a = a + b;
		System.out.println(a);
	}

	private static void compareString() {
		String s1 = "abc";
		String s2 = "abc";
		if (s1 == s2)
			System.out.println(1);
		else
			System.out.println(2);
		if (s1.equals(s2))
			System.out.println(3);
		else
			System.out.println(4);
	}

	private static void compareChar() {

	}

	public static void main(String args[]) {
		// replaceString();
		// printChar();
		// concat();
		// nullString();
		// concat2();
		// subString();
		compareString();
	}
}
