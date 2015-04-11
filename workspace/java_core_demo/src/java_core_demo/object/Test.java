package java_core_demo.object;

public class Test {
	final static int i = 1;

	public static void main(String a[]) {
		class B {
			void method() {
				System.out.println("Method B");
			}
		}
		B b = new B();
		b.method();
	}
}
