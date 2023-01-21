package com.example.dataanalyticsservice.service;

import com.example.dataanalyticsservice.model.Bill;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.function.Function;

@Service
public class BillAnalyticsService {

    @Bean
    public Function<KStream<String,Bill>,KStream<String,Long>> kStreamFunction(){

        return(input)->{
            return input
                    .filter((k,v)->v.getCustomerId()>100)
                    .map((k,v)->new KeyValue<>(v.getCustomerId().toString(),0L))
                    .groupBy((k,v)->k, Grouped.with(Serdes.String(), Serdes.Long()))
                    .windowedBy(TimeWindows.of(Duration.ofSeconds(5)))
                    .count(Materialized.as("page-count"))
                    .toStream()
                    .map((k,v)->new KeyValue<>("=>"+k.window().startTime()+k.window().endTime()+k.key(),v));
        };
    }
}
