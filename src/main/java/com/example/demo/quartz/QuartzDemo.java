package com.example.demo.quartz;

import com.example.demo.controller.ClientController;
import com.example.demo.service.SelectService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

public class QuartzDemo implements Job {

    @Autowired
    private SelectService selectService;
    @Autowired
    private ClientController clientController;

    @Override
    public void execute(JobExecutionContext jobExecutionContext){

        try {
            clientController.HttpPostDataAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("定时任务开启成功");
    }
}
