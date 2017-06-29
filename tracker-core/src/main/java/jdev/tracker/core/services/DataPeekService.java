package jdev.tracker.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataPeekService {

    @Autowired
    private DataSendService dataSendService;

    @PostConstruct
    public void init() {
        dataSendService.callFromInit();
        System.out.println("DataPeekService.init");
    }
}