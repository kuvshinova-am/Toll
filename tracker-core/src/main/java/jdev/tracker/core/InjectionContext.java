package jdev.tracker.core;

import jdev.tracker.core.services.DataPeekService;
import jdev.tracker.core.services.DataSendService;
import jdev.tracker.core.services.GpsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class InjectionContext {

    @Bean
    public GpsService gpsService() {
        return new GpsService();
    }
    @Bean
    public DataPeekService peekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService sendService() {
        return new DataSendService();
    }
}
