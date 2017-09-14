package me.mawood.data_api_client.accessors;

import me.mawood.data_api_client.objects.Reading;
import me.mawood.data_api_client.accessors.responses.ReadingResponse;
import me.mawood.data_api_client.accessors.responses.TextResponse;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
public class ReadingAccessor
{
    private static final String MODULE_URI = "device";
    private final String baseUri;
    private final Client client;
    private final HashMap<String, WebTarget> webTargets;

    public ReadingAccessor(String baseUri)
    {
        this.baseUri = baseUri;
        client = ClientBuilder.newClient();
        webTargets = new HashMap<>();
    }

    private WebTarget getTarget(final String deviceTag, final String dataTypeTag)
    {
        final String key = deviceTag + "/" + dataTypeTag;
        if(!webTargets.containsKey(key)) webTargets.put(key,client.target(baseUri).path(MODULE_URI).path(deviceTag).path(dataTypeTag));
        return webTargets.get(key);
    }

    public Collection<Reading> getReadingsFor(String device, String dataType, long startEpoch, long endEpoch)
    {
        Invocation.Builder invocationBuilder =
                getTarget(device,dataType)
                        .queryParam("start", startEpoch)
                        .queryParam("end", endEpoch)
                        .request("application/json");
        Response response = invocationBuilder.get();
        ReadingResponse r = response.readEntity(ReadingResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());

        return r.getData();
    }

    public Collection<Reading> getReadingsFor(String device, String dataType, Instant start, Instant end)
    {
        return getReadingsFor(device,dataType,start.toEpochMilli(),end.toEpochMilli());
    }

    public Collection<Reading> getReadingsFor(String device, String dataType)
    {
        Response response =  getTarget(device,dataType).request("application/json").get();
        ReadingResponse r = response.readEntity(ReadingResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
        return r.getData();
    }

    public void addReading(String device, String dataType, Reading[] readings)
    {
        Response response = getTarget(device,dataType).request("application/json").post(Entity.json(readings));
        TextResponse r = response.readEntity(TextResponse.class);
        if(!r.isSucceeded()) throw new BadRequestException("Failed with message: '" + r.getMessage() + "'");
        if(response.getStatus() != 200) throw new BadRequestException("Failed with code: " + response.getStatus());
    }
}
