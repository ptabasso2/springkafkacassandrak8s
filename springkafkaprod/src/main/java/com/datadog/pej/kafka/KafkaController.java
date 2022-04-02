package com.datadog.pej.kafka;

import com.datadog.pej.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class KafkaController {

    @Autowired
    private Sender sender;

    @RequestMapping("/test")
    public String index(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        sender.send("Un message plus long");
        return "\ntest";
    }


}
