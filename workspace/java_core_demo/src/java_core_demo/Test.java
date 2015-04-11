package java_core_demo;

import java.util.HashSet;

public class Test {
	static interface I {
		static class Test2 {
		}
	}

	public static void main(String a[]) {
		Test.I.Test2 ob1 = new Test.I.Test2();
		System.out.println("object created");
	}
}
