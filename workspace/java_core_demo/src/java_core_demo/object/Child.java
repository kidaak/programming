package java_core_demo.object;

public class Child extends Parent {

	@Override
	public void method() {
		System.out.println("Child method");
	}

	public static void main(String args[]) {
		Parent p = new Child();
		p.method();
	}

}
