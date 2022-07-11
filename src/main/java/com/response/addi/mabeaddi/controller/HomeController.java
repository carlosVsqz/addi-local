package com.response.addi.mabeaddi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Map;

@RestController
public class HomeController extends AbstractControllerCm implements ErrorController {

  private static final String HOME_PATH = "/";
  private static final String ERROR_PATH = HOME_PATH + "error";
  private static final String ACTUATOR_REDIRECT = "/actuator/mappings";
  private static final String ERROR_STATUS_CODE = "javax.servlet.error.status_code";

  @Autowired
  private ErrorAttributes errorAttributes;

  @RequestMapping(HOME_PATH)
  public ResponseEntity<Void> home() {
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(URI.create(ACTUATOR_REDIRECT));
    return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
  }

  @RequestMapping(value = ERROR_PATH)
  public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
    WebRequest webRequest = new ServletWebRequest(request);
    ErrorAttributeOptions options = ErrorAttributeOptions
        .defaults()
        .including(ErrorAttributeOptions.Include.MESSAGE);

    final Map<String, Object> body = errorAttributes.getErrorAttributes(webRequest, options);
    HttpStatus status = getStatus(request);
    return new ResponseEntity<>(body, status);
  }

  private HttpStatus getStatus(final HttpServletRequest request) {
    Integer statusCode = (Integer) request.getAttribute(ERROR_STATUS_CODE);
    if (statusCode != null) {
      try {
        return HttpStatus.valueOf(statusCode);
      } catch (Exception ex) {
        LOG.error("Error in HomeController: {}", ex);
      }
    }
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }
}