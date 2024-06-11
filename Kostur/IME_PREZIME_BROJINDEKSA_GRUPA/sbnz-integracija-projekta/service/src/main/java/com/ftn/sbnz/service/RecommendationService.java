package com.ftn.sbnz.service;

import com.ftn.sbnz.model.models.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.time.SessionPseudoClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

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

        SessionPseudoClock clock = kieSession.getSessionClock();

        kieSession.insert(ip);
        kieSession.insert(score);
        for(Place p: places.getPlaces()){
            kieSession.insert(p);
            kieSession.insert(new RuleChain());
            int ruleCount = kieSession.fireAllRules();
            p.cpScore(score);
            score.reset();
            clock.advanceTime(1, TimeUnit.MINUTES);
        }
        kieSession.dispose();
        return places.best();
    }
}
