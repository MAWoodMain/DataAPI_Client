package me.mawood.data_api_client.accessors;

import me.mawood.data_api_client.objects.DataType;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.fail;

/**
 * data_api_client
 * Created by Matthew Wood on 14/09/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataTypeAccessorTest
{

    private DataTypeAccessor accessor;
    private DataType testType;
    private DataType testType2;

    @Before
    public void setUp() throws Exception
    {
        accessor = new DataTypeAccessor("http://localhost:8080");
        testType = new DataType();
        testType.setName("Test type");
        testType.setTag("test");
        testType.setSymbol("X");
        testType.setDescription("description");

        testType2 = new DataType();
        testType2.setName("Test type 2");
        testType2.setTag("test2");
        testType2.setSymbol("Y");
        testType2.setDescription("description");
    }

    @Test
    public void getDataTypes() throws Exception
    {
        try
        {
            System.out.println(accessor.getDataTypes());
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }

    @Test
    public void addDataType() throws Exception
    {
        try
        {
            accessor.addDataType(testType);
            accessor.addDataType(testType2);
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
        System.out.println("Adding same device again, should fail");
        try
        {
            accessor.addDataType(testType);
            accessor.addDataType(testType2);
            fail("Adding duplicate device succeeded?");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteDataTypeByTag() throws Exception
    {
        try
        {
            accessor.deleteDataType(testType.getTag());
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
        System.out.println("Deleting same device again, should fail");
        try
        {
            accessor.deleteDataType(testType.getTag());
            fail("Deleting non existing device succeeded?");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteDataType() throws Exception
    {
        try
        {
            accessor.deleteDataType(testType2);
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
        System.out.println("Deleting same device again, should fail");
        try
        {
            accessor.deleteDataType(testType2);
            fail("Deleting non existing device succeeded?");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getDataType() throws Exception
    {
        try
        {
            accessor.getDataType("voltage");
        } catch (Exception e)
        {
            fail("Request failed exception: " + e.getMessage());
        }
    }

}