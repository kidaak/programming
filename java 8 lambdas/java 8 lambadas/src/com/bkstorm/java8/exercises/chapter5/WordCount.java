/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.java8.exercises.chapter5;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author hoangnv
 */
public class WordCount {
       public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(Collectors.groupingBy(name -> name, Collectors.counting()));
    } 
}
