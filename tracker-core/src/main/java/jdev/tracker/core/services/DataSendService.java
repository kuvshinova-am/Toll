package jdev.tracker.core.services;

import org.springframework.stereotype.Service;

@Service
public class DataSendService {
    public void callFromInit() {
        System.out.println("DataSendService.callFromInit");
    }
}
