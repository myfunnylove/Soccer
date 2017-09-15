package locidnet.soccer.uz.model;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class Match {

    private int id;
    private String datetime;
    private String hostName;
    private String hostSchet;
    private String guestName;
    private String guestSchet;
    private String league;
    public Match(int id, String datetime, String hostName, String hostSchet, String guestName, String guestSchet, String league) {
        this.id = id;
        this.datetime = datetime;
        this.hostName = hostName;
        this.hostSchet = hostSchet;
        this.guestName = guestName;
        this.guestSchet = guestSchet;
        this.league = league;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostSchet() {
        return hostSchet;
    }

    public void setHostSchet(String hostSchet) {
        this.hostSchet = hostSchet;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestSchet() {
        return guestSchet;
    }

    public void setGuestSchet(String guestSchet) {
        this.guestSchet = guestSchet;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }
}
