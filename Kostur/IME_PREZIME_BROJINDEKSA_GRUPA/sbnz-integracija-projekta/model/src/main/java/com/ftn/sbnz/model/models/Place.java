package com.ftn.sbnz.model.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Place implements Serializable {
    String naziv;
    String zemlja;
    String kontinent;
    float prosecna_cena;
    float prosecna_temperatura;
    int nocni_zivot;
    int urbanost;
    int[] najposeceniji_period_godine;
    Boolean dostupnost_gradskog_prevoza;
    int luksuz;
    Boolean vodene_povrsine;
    int hrana;
    Boolean skijalista;
    Score score;

    public void cpScore(Score score) {
        this.score.First = score.First;
        this.score.Second = score.Second;
        this.score.Third = score.Third;
        this.score.Fourth = score.Fourth;
        this.score.Fifth = score.Fifth;
        this.score.Sixth = score.Sixth;
        this.score.Seventh = score.Seventh;
        this.score.Eighth = score.Eighth;
        this.score.Ninth = score.Ninth;
        this.score.Tenth = score.Tenth;
    }
}
