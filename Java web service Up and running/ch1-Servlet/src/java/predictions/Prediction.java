package predictions;

import java.io.Serializable;

public class Prediction implements Serializable, Comparable<Prediction> {

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
}
