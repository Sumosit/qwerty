package db;

public class Forum {
    private int id;
    private String title;
    private String sinfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinfo() {
        return sinfo;
    }

    public void setSinfo(String sinfo) {
        this.sinfo = sinfo;
    }

    public Forum(int id, String title, String sinfo) {
        this.id = id;
        this.title = title;
        this.sinfo = sinfo;
    }
}
