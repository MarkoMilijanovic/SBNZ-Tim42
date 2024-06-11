package com.ftn.sbnz.model.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class Score implements Serializable {
    boolean First;
    boolean Second;
    boolean Third;
    boolean Fourth;
    boolean Fifth;
    boolean Sixth;
    boolean Seventh;
    boolean Eighth;
    boolean Ninth;
    boolean Tenth;

    public void reset() {
        this.First = false;
        this.Second = false;
        this.Third = false;
        this.Fourth = false;
        this.Fifth = false;
        this.Sixth = false;
        this.Seventh = false;
        this.Eighth = false;
        this.Ninth = false;
        this.Tenth = false;
    }
    public Score(){
        this.First = false;
        this.Second = false;
        this.Third = false;
        this.Fourth = false;
        this.Fifth = false;
        this.Sixth = false;
        this.Seventh = false;
        this.Eighth = false;
        this.Ninth = false;
        this.Tenth = false;
    }
    public int calculateScore(){
        int score = 0;
        if(this.First){score++;}
        if(this.Second){score++;}
        if(this.Third){score++;}
        if(this.Fourth){score++;}
        if(this.Fifth){score++;}
        if(this.Sixth){score++;}
        if(this.Seventh){score++;}
        if(this.Eighth){score++;}
        if(this.Ninth){score++;}
        if(this.Tenth){score++;}
        return score;
    }
}
