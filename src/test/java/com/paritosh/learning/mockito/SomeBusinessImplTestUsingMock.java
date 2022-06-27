package com.paritosh.learning.mockito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class SomeBusinessImplTestUsingMock {
    @Test
    public void testGetLargest() throws Exception{
        DataService dataService = mock(DataService.class);
        when(dataService.getSomeData()).thenReturn(new int[] {5,10,20});
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setService(dataService);
        int result = someBusiness.getLargest();
        assertEquals(20,result);

    }

    @Test
    public void testGetLargestNegative()  throws Exception{
        DataService dataService = mock(DataService.class);
        when(dataService.getSomeData()).thenReturn(new int[] {-5,-10,-20});
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setService(dataService);
        int result = someBusiness.getLargest();
        assertEquals(-5,result);

    }
}
