/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author hoangnv
 */
@XmlRootElement(name = "adage")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"words", "wordCount"})
public class Adage {

    protected String words;
    protected int wordCount;

    public Adage() {
    }

    // overrides
    @Override
    public String toString() {
        return words + " -- " + wordCount + " words";
    }

    // properties
    public void setWords(String words) {
        this.words = words;
        this.wordCount = words.trim().split("\\s+").length;
    }

    public String getWords() {
        return this.words;
    }

    public void setWordCount(int wordCount) {
    }

    public int getWordCount() {
        return this.wordCount;
    }
}
