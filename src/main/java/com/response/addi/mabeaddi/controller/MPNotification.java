package com.response.addi.mabeaddi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mpnotifications/mercadopagov2")
public class MPNotification extends AbstractControllerCm{

  public static final String WEBHOOKS = "webhooks";

  @PostMapping(value = "/notification/receiver", consumes = {MediaType.APPLICATION_JSON_VALUE})
  public <T> ResponseEntity<T> onRecibe(@RequestBody final T item,
                                        @RequestParam(value = "source_news", defaultValue = "") final String prm)
      throws JsonProcessingException {
    if(prm.equals(WEBHOOKS)){
      LOG.info("is process from webhook!!!");
    }
    logItem(item);
    return ResponseEntity.ok(item);
  }

}
