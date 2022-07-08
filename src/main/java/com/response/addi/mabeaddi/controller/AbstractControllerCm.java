package com.response.addi.mabeaddi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractControllerCm {

  Logger LOG = LoggerFactory.getLogger(AbstractControllerCm.class);

  protected <T> void logItem( T item ) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
    LOG.info(jsonInString);
  }

}

class Response<T>{

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

class ResponseAddi<T>{

  private static ResponseAddi<?> current = null;

  private T item;

  public ResponseAddi() {
    this.item = null;
  }

  public static ResponseAddi getInstance() {
    if (current == null)
      current = new ResponseAddi();
    return current;
  }

  public T getAddiItem() {
    return item;
  }

  public void setAddiItem(T item) {
    this.item = item;
  }
}
