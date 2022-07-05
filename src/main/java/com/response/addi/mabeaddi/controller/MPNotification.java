package com.response.addi.mabeaddi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mpnotifications/mercadopagov2")
public class MPNotification extends AbstractControllerCm {

  public static final String WEBHOOKS = "webhooks";

  @PostMapping(value = "/notification/receiver", consumes = {MediaType.APPLICATION_JSON_VALUE})
  public <T> ResponseEntity<T> onRecibe(@RequestBody final T item,
                                        @RequestParam(value = "source_news", defaultValue = "") final String prm)
      throws JsonProcessingException {
    if (prm.equals(WEBHOOKS)) {
      LOG.info("is process from webhook!!!");
    }
    logItem(item);

    Response.getInstance().setItem(item);
    return ResponseEntity.ok(item);
  }

  @GetMapping("/get-current-mp-notification")
  public <T> ResponseEntity getRecibe() {

    T item = (T) Response.getInstance().getItem();

    if(item == null){
      LOG.info("No current response found!!!");
      return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    return ResponseEntity.ok(item);
  }

}

class Response<T> {

  private static Response<?> current = null;

  private T item;

  public Response() {
    this.item = null;
  }

  public static Response getInstance() {
    if (current == null)
      current = new Response();
    return current;
  }

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }
}