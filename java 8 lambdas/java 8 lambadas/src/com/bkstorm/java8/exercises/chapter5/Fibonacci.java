/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.java8.exercises.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hoangnv
 */
public class Fibonacci {

    private final Map<Integer, Long> cache;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0l);
        cache.put(1, 1l);
    }

    public long fibonacci(int x) {
        return cache.computeIfAbsent(x, n -> fibonacci(n - 1) + fibonacci(n - 2));
    }
}
