package notebook.model;

import java.time.LocalDateTime;

public class Memo {
    private long id;
    private String topic;
    private String context;
    private LocalDateTime creationDateTime;
    private String comment;

    public Memo(long id, String topic, String context, LocalDateTime creationDateTime, String comment) {
        this.id = id;
        this.topic = topic;
        this.context = context;
        this.creationDateTime = creationDateTime;
        this.comment = comment;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


