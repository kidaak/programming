package java_core_demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class CollectionTest {
	private static void mapTest() {
		Map<String, String> map = new HashMap<>();
		String test = "HELLO";
		map.put("1", test);
		map.put("2", test);
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}

	private static void linkedlist() {
		List list = new LinkedList();
		list.add("[");
		list.add("A");
		list.add("]");
		System.out.println(list);
		ListIterator it = list.listIterator();
		while (it.hasNext()) {
			if ("[".equals(it.next()) || "]".equals(it.next()))
				it.remove();
			else
				it.add("*");
		}
		System.out.println(list);
	}

	public static void main(String args[]) {
		// mapTest();
		linkedlist();
	}
}
