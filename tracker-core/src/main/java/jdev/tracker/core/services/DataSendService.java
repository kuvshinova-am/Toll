package jdev.tracker.core.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataSendService {

    @Scheduled(cron = "*/60 * * * * *")
    public void callFromInit() {
        System.out.println("DataSendService.callFromInit");
    }
}
