package jdev.tracker.core.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataSendService {

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);

    @Autowired
    private DataPeekService dataPeekService;

    @Scheduled(cron = "*/60 * * * * *")
    public void sendToServer() throws InterruptedException, JsonProcessingException {
        log.info(dataPeekService.get().toJson());
    }
}
