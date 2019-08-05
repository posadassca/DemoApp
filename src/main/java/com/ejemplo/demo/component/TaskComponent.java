package com.ejemplo.demo.component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component("taskComponent")
public class TaskComponent {

    private static final Log LOG = LogFactory.getLog(TaskComponent.class);

    @Scheduled(fixedDelay = 5000)
    public void doTask(){
        LOG.info("TIME IS: " + LocalDate.now());
    }

}
