package backend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Post class implementing Publishable including comments
 */
public class Post implements Publishable {

    private Content content;
    private int likes;
    private final ArrayList<Comment> comments = new ArrayList<>();

    //constructor overriding
    public Post() {
    }

    public Post(Content content) {
        this.content = content;
    }

    //Publishable method overriding

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
        j.put("likes", likes);

        JSONArray arr = new JSONArray();
        for (Comment c : comments) arr.put(c.toJson());
        j.put("comments", arr);
        return j;
    }


    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void like() {
        likes++;
    }


    public void setContent(Content c) {
        this.content = c;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int l) {
        this.likes = l;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setCommentsFromList(ArrayList<Comment> list) {
        comments.clear();
        comments.addAll(list);
    }
}