package db;

import java.sql.Timestamp;

public class Comments {
    private int id;
    private String acname;
    private String comment;
    private Timestamp time;

    public Comments(int id, String acname, String comment, Timestamp time) {
        this.id = id;
        this.acname = acname;
        this.comment = comment;
        this.time = time;
    }

    public String getAcname() {
        return acname;
    }

    public void setAcname(String acname) {
        this.acname = acname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
