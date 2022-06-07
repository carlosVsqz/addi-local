package com.response.addi.mabeaddi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.response.addi.mabeaddi.model.AddiNotificationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notification")
public class AddiNotification {
    Logger LOG = LoggerFactory.getLogger(AddiNotification.class);

    @PostMapping
    public ResponseEntity<String> recibeNotification(@Validated @RequestBody AddiNotificationModel addiResponse)
            throws JsonProcessingException {

        logAddiDtoToJson(addiResponse);
        return ResponseEntity.ok("Success");
    }

    private void logAddiDtoToJson(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        LOG.info(jsonInString);
    }
}
