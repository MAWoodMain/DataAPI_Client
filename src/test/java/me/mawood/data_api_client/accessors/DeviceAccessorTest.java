package me.mawood.data_api_client.accessors;

import me.mawood.data_api_client.objects.Device;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceAccessorTest
{

    private DeviceAccessor accessor;
    private Device testDevice;
    private Device testDevice2;

    @Before
    public void setUp() throws Exception
    {
        accessor = new DeviceAccessor("http://silent-fox/api/");
        testDevice = new Device();
        testDevice.setName("Test Device");
        testDevice.setTag("test");
        testDevice.setDescription("description");

        testDevice2 = new Device();
        testDevice2.setName("Test Device 2");
        testDevice2.setTag("test2");
        testDevice2.setDescription("description");
    }

    @Test
    public void getDevices() throws Exception
    {
        try
        {
            System.out.println(accessor.getDevices());
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }

    @Test
    public void addDevice() throws Exception
    {
        try
        {
            accessor.addDevice(testDevice);
            accessor.addDevice(testDevice2);
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
        System.out.println("Adding same device again, should fail");
        try
        {
            accessor.addDevice(testDevice);
            accessor.addDevice(testDevice2);
            fail("Adding duplicate device succeeded?");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteDeviceByTag() throws Exception
    {
        try
        {
            accessor.deleteDevice(testDevice.getTag());
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
        System.out.println("Deleting same device again, should fail");
        try
        {
            accessor.deleteDevice(testDevice.getTag());
            fail("Deleting non existing device succeeded?");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteDevice() throws Exception
    {
        try
        {
            accessor.deleteDevice(testDevice2);
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
        System.out.println("Deleting same device again, should fail");
        try
        {
            accessor.deleteDevice(testDevice2);
            fail("Deleting non existing device succeeded?");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getDevice() throws Exception
    {
        try
        {
            accessor.getDevice("whole_house");
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }

}