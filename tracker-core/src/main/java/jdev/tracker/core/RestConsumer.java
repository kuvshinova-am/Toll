package jdev.tracker.core;

import jdev.tracker.core.services.DataPeekService;
import jdev.tracker.core.services.DataSendService;
import jdev.tracker.core.services.GpsService;
import jdev.tracker.core.services.TrackService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"units","services"})
@EnableScheduling
public class RestConsumer {
    public static void main(String[] args) {
        SpringApplication.run(RestConsumer.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public DataPeekService dataPeekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService dataSendService() {
        return new DataSendService();
    }

    @Bean
    public GpsService gpsService() {
        return new GpsService();
    }

    @Bean
    public TrackService trackService() {
        return new TrackService();
    }
}

