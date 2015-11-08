/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.java8.exercises.chapter5;

import com.bkstorm.java8.exercises.chapter1.Artist;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

/**
 *
 * @author hoangnv
 */
public class LongestName {

    private static final Comparator<Artist> byNameLenght = Comparator.comparing(artist -> artist.getName().length());

    public static Artist byReduce(List<Artist> artists) {
        return artists.stream().reduce((acc, artist) -> {
            return byNameLenght.compare(acc, artist) >= 0 ? acc : artist;
        }).orElseThrow(RuntimeException::new);
    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream().collect(Collectors.maxBy(byNameLenght)).orElseThrow(RuntimeException::new);
    }
}
