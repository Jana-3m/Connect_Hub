package backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents the shared data (text, image, timestamp, author) for any piece
 * of user content; composition in Post, Stories, Comments.
 */
public class Content {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String contentId;
    private String authorId;
    private String text;
    private LocalDate timestamp;
    private String imagePath;

    public Content() {

    }

    public Content(String contentId, String authorId, String text, LocalDate timestamp, String imagePath) {
        this.contentId = contentId;
        this.authorId = authorId;
        this.text = text;
        this.timestamp = timestamp;
        this.imagePath = imagePath;
    }


    public String getContentId() {
        return contentId;
    }

    public void setContentId(String id) {
        this.contentId = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String id) {
        this.authorId = id;
    }

    public String getContent() {
        return text;
    }

    public void setContent(String text) {
        this.text = text;
    }

    public LocalDate getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(LocalDate d) {
        this.timestamp = d;
    }

    public String getImage() {
        return imagePath;
    }

    public void setImage(String path) {
        this.imagePath = path;
    }

    public String dateToStringFormat(LocalDate d) {
        return d == null ? "" : d.format(DATE_FMT);
    }
}