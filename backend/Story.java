package backend;

import org.json.JSONObject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A story implementing Publishable
 */
public class Story implements Publishable {

    private Content content;

    public Story() {
    }

    public Story(Content content) {
        this.content = content;
    }

    //Publishable overriding
    public void setContent(Content c) {
        this.content = c;
    }

    @Override
    public Content getContent() {
        return content;
    }

    @Override
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("contentId", content.getContentId());
        j.put("authorId", content.getAuthorId());
        j.put("content", content.getContent());
        j.put("image", content.getImage() == null ? "" : content.getImage());
        j.put("date", content.dateToStringFormat(content.getTimeStamp()));
        return j;
    }

    // returns true if story older than 24 hours to remove.
    public boolean isExpired() {
        LocalDate ts = content.getTimeStamp();
        if (ts == null) return true;
        long hours = ChronoUnit.HOURS.between(ts.atStartOfDay(), LocalDate.now().atStartOfDay());
        return hours >= 24;
    }


}