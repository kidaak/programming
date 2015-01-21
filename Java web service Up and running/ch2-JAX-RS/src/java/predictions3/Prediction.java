/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictions3;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangnv
 */
@XmlRootElement(name = "prediction")
public class Prediction implements Comparable<Prediction> {

    private String who;   // person
    private String what;  // his/her prediction
    private int id; // identifier used as lookup key

    public Prediction() {
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWho() {
        return this.who;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhat() {
        return this.what;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Prediction other) {
        return this.id - other.id;
    }

    @Override
    public String toString() {
        return String.format("%2d: ", id) + who + " ==> " + what + "\n";
    }
}
