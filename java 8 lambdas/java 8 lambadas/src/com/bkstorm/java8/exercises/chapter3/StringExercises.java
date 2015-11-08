/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.java8.exercises.chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hoangnv
 */
public class StringExercises {

    // Question 7
    public static int countLowercaseLetters(String string) {
        return (int) string.chars().filter(Character::isLowerCase).count();
    }

    // Question 8
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(StringExercises::countLowercaseLetters));
    }
}
