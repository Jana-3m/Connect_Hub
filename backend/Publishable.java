package backend;

/**
 * Post (+ cmnts) , Stories, anything that can be published
 *
 * Design pattern: Composite, treating individual and compositions of objects in the same way through interface.
 */
public interface Publishable {
    Content getContent();
    org.json.JSONObject toJson();
}