package jdev.tracker.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataPeekService {

    @Autowired
    private DataSendService dataSendService;
}