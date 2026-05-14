package com.example.spring_lab3_notifications;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    void shouldSpyOnList() {
        List<String> spyList = spy(new ArrayList<>());

        //when(spyList.size()).thenReturn(100);

        spyList.add("Spring");

        //assertEquals(100, spyList.size());
        verify(spyList).add("Spring");
    }
}