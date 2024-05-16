package com.ftn.sbnz.model.events;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("10m")
public class RecommendationEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    public RecommendationEvent() {
        super();
    }
}
