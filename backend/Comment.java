package backend;

import org.json.JSONObject;

/**
 * A comment inside a Post, with the same content structure
 * LSP, a comment is not a subtype of Post.
 */
public class Comment {

    private Content content;

    public Comment() {
    }

    public Comment(Content content) {
        this.content = content;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content c) {
        this.content = c;
    }

    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("authorId", content.getAuthorId());
        j.put("content", content.getContent());
        j.put("date", content.dateToStringFormat(content.getTimeStamp()));
        return j;
    }
}