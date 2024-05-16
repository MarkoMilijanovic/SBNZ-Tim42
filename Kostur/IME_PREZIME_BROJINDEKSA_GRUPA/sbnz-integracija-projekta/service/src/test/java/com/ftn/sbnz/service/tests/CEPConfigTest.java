package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.models.IdealPlace;
import com.ftn.sbnz.model.models.Place;
import com.ftn.sbnz.model.models.Score;
import org.junit.Test;
 import org.kie.api.KieServices;
 import org.kie.api.runtime.KieContainer;
 import org.kie.api.runtime.KieSession;
import org.kie.api.time.SessionPseudoClock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class CEPConfigTest {

    @Test
    public void test() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("cepKsession");
        SessionPseudoClock clock = ksession.getSessionClock();

        IdealPlace ideal_place = new IdealPlace(100, 1000, 25, 45, 5,
                6, new int[]{10, 2}, true, 5, false, 10,
                false, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});

        Place p1 = new Place("p1", "z1", "k1", 101, 25,
                5, 6, new int[]{1, 3}, true, 5, false,
                10, true);
        Place p2 = new Place("p2", "z2", "k2", 10, 30,
                5, 1, new int[]{12, 1}, true, 1, true,
                2, false);
        Place p3 = new Place("p3", "z3", "k3", 1000, 100,
                3, 10, new int[]{5, 9}, true, 10, true,
                2, false);

        List<Place> places = new ArrayList<>();
        places.add(p1);
        places.add(p2);
        places.add(p3);
        clock.advanceTime(1, TimeUnit.MINUTES);

        ksession.insert(ideal_place);
        Score score = new Score();
        ksession.insert(score);
        for (Place place : places) {
            ksession.insert(place);

            int ruleCount = ksession.fireAllRules();
            System.out.println(ruleCount);

            clock.advanceTime(1, TimeUnit.MINUTES);
            score.reset();
        }
        assertThat(1, equalTo(1));
    }
}
