package me.mawood.data_api_client.accessors.responses;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
public class TextResponse
{
    private String data;
    private boolean succeeded;
    private String message;

    public TextResponse()
    {
    }

    public String getData()
    {
        return data;
    }

    public boolean isSucceeded()
    {
        return succeeded;
    }

    public String getMessage()
    {
        return message;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public void setSucceeded(boolean succeeded)
    {
        this.succeeded = succeeded;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "Response{" +
                "data=" + data +
                ", succeeded=" + succeeded +
                ", message='" + message + '\'' +
                '}';
    }
}
