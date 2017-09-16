package locidnet.soccer.uz.model;

/**
 * Created by Sarvar on 16.09.2017.
 */

public class MatchTable {

    private int id;
    private String leauge;
    private String position;
    private String logo;
    private String name;
    private String match;
    private String win;
    private String nichya;
    private String fall;
    private String score;

    public MatchTable(int id, String leauge, String position, String logo, String name, String match, String win, String nichya, String fall, String score) {
        this.id = id;
        this.leauge = leauge;
        this.position = position;
        this.logo = logo;
        this.name = name;
        this.match = match;
        this.win = win;
        this.nichya = nichya;
        this.fall = fall;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getLeauge() {
        return leauge;
    }

    public String getPosition() {
        return position;
    }

    public String getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getMatch() {
        return match;
    }

    public String getWin() {
        return win;
    }

    public String getNichya() {
        return nichya;
    }

    public String getFall() {
        return fall;
    }

    public String getScore() {
        return score;
    }
}
