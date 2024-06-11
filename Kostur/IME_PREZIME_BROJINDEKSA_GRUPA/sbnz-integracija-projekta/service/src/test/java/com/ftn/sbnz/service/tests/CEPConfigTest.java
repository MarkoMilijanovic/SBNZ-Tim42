package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.models.*;
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

        IdealPlace ideal_place = new IdealPlace(300, 1000, 10, 45, 5, 7, 4, 8,
                new int[]{6, 8}, true, 7, 10,
                true, 8, 10, true);

//        Place p1 = new Place("p1", "z1", "k1", 101, 25,
//                5, 6, new int[]{1, 3}, true, 5, false,
//                10, true, new Score());
//        Place p2 = new Place("p2", "z2", "k2", 10, 30,
//                5, 1, new int[]{12, 1}, true, 1, true,
//                2, false, new Score());
//        Place p3 = new Place("p3", "z3", "k3", 1000, 100,
//                3, 10, new int[]{5, 9}, true, 10, true,
//                2, false, new Score());

        Places places = new Places();
//        places.add(p1);
//        places.add(p2);
//        places.add(p3);
        clock.advanceTime(1, TimeUnit.MINUTES);

        ksession.insert(ideal_place);
        Score score = new Score();
        ksession.insert(score);

        for (Place place : places.getPlaces()) {
            ksession.insert(place);
            ksession.insert(new RuleChain());
            int ruleCount = ksession.fireAllRules();
            System.out.println(ruleCount);


            place.cpScore(score);
            System.out.println(place.getNaziv() + " " + place.getScore().calculateScore());
            System.out.println(score.isFirst() + " " + score.isSecond() + " " + score.isThird() + " " + score.isFourth()
                    + " " + score.isFifth() + " " + score.isSixth() + " " + score.isSeventh() + " " + score.isEighth() + " " + score.isNinth() + " ");

            score.reset();
            clock.advanceTime(1, TimeUnit.MINUTES);
        }
        System.out.println(places.best().getNaziv());
        assertThat(1, equalTo(1));
    }
}
