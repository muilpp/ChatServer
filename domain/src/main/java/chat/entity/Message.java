package chat.entity;

public class Message {
    private String from;
    private String to;
    private String content;
    private long date;

    public Message(String from, String to, String content, long date) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.date = date;
    }

    public static Message create(String from, String to, String content) {
        return new Message(from, to, content, System.currentTimeMillis());
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public long getDate() {
        return date;
    }
}