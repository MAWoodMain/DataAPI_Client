package me.mawood.data_api_client.accessors;

import me.mawood.data_api_client.objects.Reading;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReadingAccessorTest
{
    private ReadingAccessor accessor;

    @Before
    public void setUp() throws Exception
    {
        accessor = new ReadingAccessor("http://silent-fox/api/");
    }
    @Test
    public void getReadingsForWithEpoch() throws Exception
    {
        long startTime, endTime, duration;
        Collection<Reading> response;
        try
        {
            for (int i = 0; i < 10; i++)
            {
                startTime = System.nanoTime();
                response = accessor.getReadingsFor("whole_house", "voltage",
                        Instant.now().minusSeconds(120).toEpochMilli(), Instant.now().toEpochMilli());
                endTime = System.nanoTime();
                duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
                System.out.println("read " + response.size() + " in " + duration / 1000000 + "ms ");
            }
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }

    @Test
    public void getReadingsForWithInstants() throws Exception
    {
        long startTime, endTime, duration;
        Collection<Reading> response;
        try
        {
            for (int i = 0; i < 10; i++)
            {
                startTime = System.nanoTime();
                response = accessor.getReadingsFor("whole_house", "voltage",
                        Instant.now().minusSeconds(120), Instant.now());
                endTime = System.nanoTime();
                duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
                System.out.println("read " + response.size() + " in " + duration / 1000000 + "ms ");
            }
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }

    @Test
    public void getReadingsFor() throws Exception
    {
        long startTime, endTime, duration;
        Collection<Reading> response;
        try
        {
            for (int i = 0; i < 10; i++)
            {
                startTime = System.nanoTime();
                response = accessor.getReadingsFor("whole_house", "voltage");
                endTime = System.nanoTime();
                duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
                System.out.println("read " + response.size() + " in " + duration / 1000000 + "ms ");
            }
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }

    @Test
    public void addReading() throws Exception
    {
        long startTime, endTime, duration;
        try
        {
            for(int i = 0; i < 10; i++)
            {
                startTime = System.nanoTime();
                accessor.addReading("whole_house","voltage", new Reading[]{new Reading(new Random().nextDouble(), Instant.now().toEpochMilli())});
                endTime = System.nanoTime();
                duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
                System.out.println("insert " + duration/1000000 + "ms");
            }
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }
}