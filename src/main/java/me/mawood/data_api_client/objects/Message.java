package me.mawood.data_api_client.objects;


public class Message
{

    private String message;
    private long timestamp;

    public Message() {
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    @Override
    public String toString()
    {
        return "Message{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}