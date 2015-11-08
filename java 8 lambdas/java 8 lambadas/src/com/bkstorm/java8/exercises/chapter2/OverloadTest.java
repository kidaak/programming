/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.java8.exercises.chapter2;

/**
 *
 * @author hoangnv
 */
public class OverloadTest {
    
    public static void main(String[] args) {
        Integer x;
        check(x -> x > 5);
    }

    static boolean check(Predicate<Integer> predicate) {
        System.out.println("predicate");
        return true;
    }

    static boolean check(IntPred intPred) {
        System.out.println("intPred");
        return true;
    }
}
