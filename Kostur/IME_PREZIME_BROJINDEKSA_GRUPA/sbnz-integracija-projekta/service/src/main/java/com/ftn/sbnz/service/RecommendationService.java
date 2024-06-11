package com.ftn.sbnz.service;

import com.ftn.sbnz.model.models.IdealPlace;
import com.ftn.sbnz.model.models.Place;
import com.ftn.sbnz.model.models.Places;
import com.ftn.sbnz.model.models.Score;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecommendationService {
    private static Logger log = LoggerFactory.getLogger(ServiceApplication.class);
    private final KieContainer kieContainer;

    @Autowired
    public RecommendationService(KieContainer kieContainer) {
        log.info("Initialising a new example session.");
        this.kieContainer = kieContainer;
    }

    public Place recommend(IdealPlace ip){
        Places places = new Places();
        Score score = new Score();

        KieSession kieSession = kieContainer.newKieSession("cepKsession");

        kieSession.insert(ip);
        kieSession.insert(score);
        for(Place p: places.getPlaces()){
            kieSession.insert(p);
            int ruleCount = kieSession.fireAllRules();
            p.cpScore(score);
            score.reset();
        }
        kieSession.dispose();
        return places.best();
    }
}
