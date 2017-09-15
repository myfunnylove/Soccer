package locidnet.soccer.uz.model;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class News {

    private int id;
    private String title;
    private String date;
    private String commentCount;
    private boolean isHot;

    public News(int id, String title, String date, String commentCount, boolean isHot) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.commentCount = commentCount;
        this.isHot = isHot;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }
}
