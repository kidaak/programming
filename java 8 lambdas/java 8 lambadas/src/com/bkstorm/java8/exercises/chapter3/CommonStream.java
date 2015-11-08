/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.java8.exercises.chapter3;

import com.bkstorm.java8.exercises.chapter1.Album;
import com.bkstorm.java8.exercises.chapter1.Artist;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author hoangnv
 */
public class CommonStream {

    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, x) -> acc + x);
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getNationality())).collect(Collectors.toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albums) {
        return albums.stream().filter(album -> album.getTrackList().size() <= 3).collect(Collectors.toList());
    }

}
