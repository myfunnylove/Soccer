package locidnet.soccer.uz.model;

/**
 * Created by Sarvar on 16.09.2017.
 */

public class Comment {

    private int id;
    private String avatar;
    private String name;
    private String time;
    private String commentText;
    private String commentScore;

    public Comment(int id, String avatar, String name, String time, String commentText, String commentScore) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.time = time;
        this.commentText = commentText;
        this.commentScore = commentScore;
    }

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getCommentScore() {
        return commentScore;
    }
}
