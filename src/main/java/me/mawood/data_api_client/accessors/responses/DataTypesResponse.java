package me.mawood.data_api_client.accessors.responses;

import me.mawood.data_api_client.objects.DataType;

import java.util.Collection;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
public class DataTypesResponse
{
    private Collection<DataType> data;
    private boolean succeeded;
    private String message;

    public DataTypesResponse()
    {
    }

    public Collection<DataType> getData()
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

    public void setData(Collection<DataType> data)
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
}
