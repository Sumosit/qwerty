package db;

public class Bookmarks {
    private String bkname;
    private String link;
    private int seria;
    private int season;

    public Bookmarks() {}

    public String getBkname() {
        return bkname;
    }

    public void setBkname(String bkname) {
        this.bkname = bkname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getSeria() {
        return seria;
    }

    public void setSeria(int seria) {
        this.seria = seria;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public Bookmarks(String bkname, String link, int season, int seria) {
        this.bkname = bkname;
        this.link = link;
        this.seria = seria;
        this.season = season;
    }
}
