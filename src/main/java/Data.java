import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Data implements Serializable {

    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final int upvotes;

    public Data(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") int upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public int getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return String.format("About cats\n userId: %s\n text: %s \n type: %s\n User: %s\n upvotes: %d",
                id, text, type, user, upvotes);
    }
}
