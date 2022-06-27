package com.paritosh.learning.mockito;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class SomeBusinessImplTestUsingStub {
    @Test
    void testGetLargest() throws Exception{
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setService(new DataServiceStub());
        int result = someBusiness.getLargest();
        assertEquals(15, result);
    }


}

class DataServiceStub implements DataService{
    @Override
    public int[] getSomeData() {
        return new int[] {5,10,15};
    }
}