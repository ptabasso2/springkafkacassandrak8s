package com.datadog.pej.kafka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KafkaController {


    @RequestMapping("/status")
    public String index() {
        return "\nstatus OK";
    }


}
