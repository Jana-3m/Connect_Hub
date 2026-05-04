package backend;

import org.json.JSONObject;

/**
 * Profile details for User.
 * SRP: profile separate from User.
 */
public class Profile {

    private static final String DEFAULT_PHOTO = "A.png";    //path to be configured
    private static final String DEFAULT_COVER = "B.jpeg";   //pathto be configured
    private static final String DEFAULT_BIO = "Using Connect_Hub!";

    private String profilePhoto;
    private String coverPhoto;
    private String bio;

    public Profile() {
        this.profilePhoto = DEFAULT_PHOTO;
        this.coverPhoto = DEFAULT_COVER;
        this.bio = DEFAULT_BIO;
    }

    public Profile(String profilePhoto, String coverPhoto, String bio) {
        this.profilePhoto = profilePhoto;
        this.coverPhoto = coverPhoto;
        this.bio = bio;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String path) {
        this.profilePhoto = path;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String path) {
        this.coverPhoto = path;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    //formatting
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("profilePhoto", profilePhoto);
        j.put("coverPhoto", coverPhoto);
        j.put("Bio", bio);
        return j;
    }

    public static Profile fromJson(JSONObject j) {
        return new Profile(j.optString("profilePhoto", DEFAULT_PHOTO), j.optString("coverPhoto", DEFAULT_COVER), j.optString("Bio", DEFAULT_BIO));
    }
}