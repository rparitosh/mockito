package com.paritosh.learning.mockito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListTest {

    @Mock
    List<Integer> list;

    @Test
    void testSize(){
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testValue(){
        when(list.get(Mockito.anyInt())).thenReturn(10).thenReturn(30);

        assertEquals(10, list.get(10));
        assertEquals(30, list.get(20));

        when(list.get(45)).thenThrow(new ArrayIndexOutOfBoundsException());
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->list.get(45));
    }

}
