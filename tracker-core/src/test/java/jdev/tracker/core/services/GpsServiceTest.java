package jdev.tracker.core.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class GpsServiceTest {

    @Mock
    private GpsService service;

    @Test
    public void getCoordinates() throws Exception {
        doThrow(new RuntimeException()).when(service).getCoordinates();
    }
}