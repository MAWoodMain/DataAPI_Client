package me.mawood.data_api_client.accessors.responses;

import me.mawood.data_api_client.objects.Reading;

import java.util.Arrays;
import java.util.Collection;

/**
 * data_api
 * Created by Matthew Wood on 09/09/2017.
 */
public class ReadingResponse
{
    private Collection<Reading> data;
    private boolean succeeded;
    private String message;

    public ReadingResponse()
    {
    }

    public Collection<Reading> getData()
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

    public void setData(Collection<Reading> data)
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
