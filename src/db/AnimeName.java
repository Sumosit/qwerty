package db;

public class AnimeName {
    private int id, views;
    private String name, image, genre, history, date, producer, links, address, seria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public AnimeName(int id, String name, int views, String image, String genre, String history,
                     String date, String producer, String links, String address) {
        this.id = id;
        this.views = views;
        this.name = name;
        this.image = image;
        this.genre = genre;
        this.history = history;
        this.date = date;
        this.producer = producer;
        this.links = links;
        this.address = address;
    }

    public AnimeName() {

    }
}
