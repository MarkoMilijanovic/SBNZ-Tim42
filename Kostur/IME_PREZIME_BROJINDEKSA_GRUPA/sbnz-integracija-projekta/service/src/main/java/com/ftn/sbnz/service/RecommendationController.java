package com.ftn.sbnz.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecommendationController {
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    public ResponseEntity<?> index() {
        return new ResponseEntity<>("recommendation", HttpStatus.OK);
    }
}
