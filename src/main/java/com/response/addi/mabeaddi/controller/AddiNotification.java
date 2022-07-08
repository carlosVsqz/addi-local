package com.response.addi.mabeaddi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.response.addi.mabeaddi.model.AddiNotificationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/notification")
public class AddiNotification extends AbstractControllerCm {

  @PostMapping
  public ResponseEntity<String> recibeNotification(@Validated @RequestBody AddiNotificationModel addiResponse)
      throws JsonProcessingException {

    if (Objects.isNull(addiResponse)) {
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    logItem(addiResponse);
    ResponseAddi.getInstance().setAddiItem(addiResponse);
    return ResponseEntity.ok("Success");
  }

  @GetMapping("/getAddiResponse")
  public <T> ResponseEntity onResponse() {
    T item = (T) ResponseAddi.getInstance().getAddiItem();

    if (item == null)
      return new ResponseEntity(HttpStatus.NO_CONTENT);

    return ResponseEntity.ok(item);
  }
}