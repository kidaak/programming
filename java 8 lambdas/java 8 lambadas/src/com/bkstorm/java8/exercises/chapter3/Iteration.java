/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bkstorm.java8.exercises.chapter3;

import com.bkstorm.java8.exercises.chapter1.Artist;
import java.util.List;

/**
 *
 * @author hoangnv
 */
public class Iteration {

    public static int countTotalMembers(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getMembers().count()).reduce(0L, (acc, x) -> Long.sum(acc, x)).intValue();
    }
}
