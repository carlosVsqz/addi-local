package com.response.addi.mabeaddi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractControllerCm {

  Logger LOG = LoggerFactory.getLogger(AbstractControllerCm.class);

  protected <T> void logItem( T item ) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
    LOG.info(jsonInString);
  }
}
