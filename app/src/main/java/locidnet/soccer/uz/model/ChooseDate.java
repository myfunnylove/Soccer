package locidnet.soccer.uz.model;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class ChooseDate {

    private String title;
    private boolean selected;

    public ChooseDate(String title, boolean selected) {
        this.title = title;
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
