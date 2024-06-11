package com.ftn.sbnz.service;

import com.ftn.sbnz.model.models.IdealPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin("http://localhost:3000")
@Controller
public class RecommendationController {
    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @RequestMapping(value = "/recommend", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> index(@RequestBody IdealPlace ideal) {
        return new ResponseEntity<>(recommendationService.recommend(ideal), HttpStatus.OK);
//        return new ResponseEntity<>(recommendationService.recommend(new IdealPlace()), HttpStatus.OK);
    }
}
