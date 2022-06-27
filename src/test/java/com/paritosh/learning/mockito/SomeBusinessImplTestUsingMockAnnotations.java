package com.paritosh.learning.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplTestUsingMockAnnotations {

    @Mock
    private DataService dataService;

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Test
    public void testGetLargest() throws Exception {
        when(dataService.getSomeData()).thenReturn(new int[] {5,10,20});
        assertEquals(20, someBusiness.getLargest());

    }

    @Test
    public void testGetLargestNegative() throws Exception{
        when(dataService.getSomeData()).thenReturn(new int[] {-5,-10,-20});
        assertEquals(-5 , someBusiness.getLargest());
    }


    @Test
    public void testGetLargestEmpty() throws Exception{
        when(dataService.getSomeData()).thenReturn(new int[] {});
        Assertions.assertThrows(Exception.class, ()-> someBusiness.getLargest());
    }

    @Test
    public void testGetLargestNull() throws Exception{
        when(dataService.getSomeData()).thenReturn(null);
        Assertions.assertThrows(NullPointerException.class, ()-> someBusiness.getLargest());
    }
}
