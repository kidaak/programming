package com.bkstorm.javase;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class TreeMapTest {

	@Test
	public void testOrderInTreeMap() {
		Map<Object, Object> map = new TreeMap<>();
		map.put(3l, 3l);
		map.put(2l, 2l);
		map.put(1l, 1l);
		Iterator<Object> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
