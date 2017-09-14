package me.mawood.data_api_client;

import me.mawood.data_api_client.accessors.DataTypeAccessor;
import me.mawood.data_api_client.accessors.DeviceAccessor;
import me.mawood.data_api_client.accessors.ReadingAccessor;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
public class Main
{

    public static void main(String[] args)
    {
        DataTypeAccessor accessor = new DataTypeAccessor("http://localhost:8080");
    }
}
