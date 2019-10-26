package db;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection conn;
    public DBManager(){}

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goa?useUnicode=true&serverTimezone=UTC  ", "ELN", "2010erlan");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int checkBookMark(String name, String anime) {

        return 0;
    }

    public void setComment(String id, String name, String text) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO fcomments (id, acname, comment) VALUE (?, ?, ?)");
            st.setString(1, id);
            st.setString(2, name);
            st.setString(3, text);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Comments> getComments(int id) {
        ArrayList<Comments> result = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM fcomments WHERE id=(?)");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                result.add(new Comments(
                        rs.getInt("id"),
                        rs.getString("acname"),
                        rs.getString("comment"),
                        rs.getTimestamp("date")
                ));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void setForum(String title, String sinfo) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO forum (title, sinfo) VALUE (?, ?)");
            st.setString(1, title);
            st.setString(2, sinfo);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delForum(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM forum WHERE id=(?)");
            st.setInt(1, id);
            st.execute();
            st.close();
            delComments(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delComments(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM fcomments WHERE id=(?)");
            st.setInt(1, id);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Forum> getForum() {
        ArrayList<Forum> result = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM forum");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                result.add(new Forum(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("sinfo")
                ));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void setBookMark(String name, String anime, String link, String season, String seria) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO bookmarks (name, bookmark, link, season, seria) VALUE (?, ?, ?, ?, ?)");
            st.setString(1, name);
            st.setString(2, anime);
            st.setString(3, link);
            st.setString(4, season);
            st.setString(5, seria);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delBookMark(String name, String anime, String season, String seria) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM bookmarks WHERE name=(?) and bookmark=(?) and season=(?) and seria=(?)");
            st.setString(1, name);
            st.setString(2, anime);
            st.setString(3, season);
            st.setString(4, seria);
            st.execute();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAccount(String email, String name, String pass) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO accounts (email, name, password) VALUE (?, ?, ?)");
            st.setString(1, email);
            st.setString(2, name);
            st.setString(3, pass);

//            account.setEmail(email);
//            account.setName(name);
//            account.setPass(pass);

            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitAccount() {
//        account.setEmail(null);
//        account.setName(null);
//        account.setPass(null);
    }

    public Account checkAccount(String name, String password) {
        Account account = new Account();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM accounts WHERE name= ? and password= ?");
            st.setString(1, name);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                account.setName(rs.getString("name"));
                account.setEmail(rs.getString("email"));
                account.setPass(rs.getString("password"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

//    public String getAcName(){
//        return account.getName();
//    }

    public void setViews(int views, String anName) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE anime set Views=? WHERE Name=?");
            st.setInt(1, views);
            st.setString(2, anName);
            st.executeUpdate();

            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<AnimeName> searchAnime(String name) {
        ArrayList<AnimeName> result = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM anime WHERE REPLACE(UPPER(Name), ' ', '')= ? " +
                    "or REPLACE (UPPER(Name), ' ', '') LIKE ?");
            st.setString(1, name);
            st.setString(2, "%"+name+"%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                result.add(new AnimeName(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("views"),
                        rs.getString("image"),
                        rs.getString("genre"),
                        rs.getString("history"),
                        rs.getString("Date"),
                        rs.getString("producer"),
                        rs.getString("links"),
                        rs.getString("address")
                ));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<AnimeName> getAllAnimeDate() {
        ArrayList<AnimeName> result = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM anime ORDER BY birth DESC");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                result.add(new AnimeName(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("views"),
                        rs.getString("image"),
                        rs.getString("genre"),
                        rs.getString("history"),
                        rs.getString("Date"),
                        rs.getString("producer"),
                        rs.getString("links"),
                        rs.getString("address")
                ));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void delAnime(String name) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM anime WHERE Name = (?)");
            st.setString(1, name);
            st.executeUpdate();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<AnimeName> getAllAnime() {
        ArrayList<AnimeName> result = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM anime ORDER BY Views DESC");
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                result.add(new AnimeName(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("views"),
                        rs.getString("image"),
                        rs.getString("genre"),
                        rs.getString("history"),
                        rs.getString("Date"),
                        rs.getString("producer"),
                        rs.getString("links"),
                        rs.getString("address")
                ));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Bookmarks> bookmarks(String name) {
        ArrayList<Bookmarks> bk = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT bookmark, link, season, seria FROM bookmarks WHERE name = ?");
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                bk.add(new Bookmarks(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }

    public ArrayList<AnimeName> FindAnime(String name) {
        ArrayList<AnimeName> result = new ArrayList<>();
        result.add(new AnimeName(0, null, 0, null, null, null, null, null, null, null));
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM anime WHERE Name = ?");
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                result.add(new AnimeName(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("views"),
                        rs.getString("image"),
                        rs.getString("genre"),
                        rs.getString("history"),
                        rs.getString("Date"),
                        rs.getString("producer"),
                        rs.getString("links"),
                        rs.getString("address")
                ));
            }
            rs.close();
            st.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
