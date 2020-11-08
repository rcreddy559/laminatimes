package com.lamina.stock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

public class InitializeData {

//    @Value("${spring.datasource.data: data22.sql}")
//    private String DATA_SOURCE;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void loadData() {
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(
//                false, false, "UTF-8", new ClassPathResource(DATA_SOURCE));
//        resourceDatabasePopulator.execute(dataSource);
//    }
}
