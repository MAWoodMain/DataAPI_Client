package me.mawood.data_api_client.accessors.responses;

import me.mawood.data_api_client.objects.DataType;
import me.mawood.data_api_client.objects.Device;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
public class DataTypeResponse
{
    private DataType data;
    private boolean succeeded;
    private String message;

    public DataTypeResponse()
    {
    }

    public DataType getData()
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

    public void setData(DataType data)
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
