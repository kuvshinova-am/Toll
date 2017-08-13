package jdev.tracker.core.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataSendServiceTest {

    @Mock
    private DataSendService service;

    @Test
    public void sendToServer() throws Exception {
        doThrow(new RuntimeException()).when(service).sendToServer();
    }
}