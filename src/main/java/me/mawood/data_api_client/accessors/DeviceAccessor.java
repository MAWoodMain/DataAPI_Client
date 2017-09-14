package me.mawood.data_api_client.accessors;

import me.mawood.data_api_client.accessors.responses.DeviceResponse;
import me.mawood.data_api_client.accessors.responses.TextResponse;
import me.mawood.data_api_client.objects.Device;
import me.mawood.data_api_client.accessors.responses.DevicesResponse;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
public class DeviceAccessor
{
    private static final String MODULE_URI = "devices";
    private final String baseUri;
    private final Client client;

    public DeviceAccessor(String baseUri)
    {
        this.baseUri = baseUri;
        client = ClientBuilder.newClient();
    }

    private WebTarget getTarget(final String deviceTag)
    {
        return client.target(baseUri).path(MODULE_URI).path(deviceTag);
    }

    public Collection<Device> getDevices()
    {
        Response response = getTarget("/").request("application/json").get();
        DevicesResponse r = response.readEntity(DevicesResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
        return r.getData();
    }

    public void addDevice(Device device)
    {
        Response response = getTarget("/").request("application/json").post(Entity.json(device));
        TextResponse r = response.readEntity(TextResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
    }

    public void deleteDevice(String deviceTag)
    {
        Response response = getTarget(deviceTag).request("application/json").delete();
        TextResponse r = response.readEntity(TextResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
    }

    public void deleteDevice(Device device)
    {
        if(device == null || device.getTag() == null || device.getTag().trim().equals(""))
            throw new IllegalArgumentException("device must have a valid tag");
        deleteDevice(device.getTag());
    }

    public Device getDevice(String deviceTag)
    {
        Response response = getTarget(deviceTag).request("application/json").get();
        DeviceResponse r = response.readEntity(DeviceResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
        return r.getData();
    }
}
