package me.mawood.data_api_client.accessors;

import me.mawood.data_api_client.accessors.responses.DataTypeResponse;
import me.mawood.data_api_client.accessors.responses.DataTypesResponse;
import me.mawood.data_api_client.accessors.responses.TextResponse;
import me.mawood.data_api_client.objects.DataType;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
public class DataTypeAccessor
{
    private static final String MODULE_URI = "datatypes";
    private final String baseUri;
    private final Client client;

    public DataTypeAccessor(String baseUri)
    {
        this.baseUri = baseUri;
        client = ClientBuilder.newClient();
    }

    private WebTarget getTarget(final String dataTypeTag)
    {
        return client.target(baseUri).path(MODULE_URI).path(dataTypeTag);
    }

    public Collection<DataType> getDataTypes()
    {
        Response response = getTarget("/").request("application/json").get();
        DataTypesResponse r = response.readEntity(DataTypesResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
        return r.getData();
    }

    public void addDataType(DataType device)
    {
        Response response = getTarget("/").request("application/json").post(Entity.json(device));
        TextResponse r = response.readEntity(TextResponse.class);
        System.out.println(r);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
    }

    public void deleteDataType(String dataType)
    {
        Response response = getTarget(dataType).request("application/json").delete();
        TextResponse r = response.readEntity(TextResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
    }

    public void deleteDataType(DataType dataType)
    {
        if(dataType == null || dataType.getTag() == null || dataType.getTag().trim().equals(""))
            throw new IllegalArgumentException("device must have a valid tag");
        deleteDataType(dataType.getTag());
    }

    public DataType getDataType(String dataType)
    {
        Response response = getTarget(dataType).request("application/json").get();
        DataTypeResponse r = response.readEntity(DataTypeResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
        return r.getData();
    }
}
