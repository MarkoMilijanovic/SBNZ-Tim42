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
public class IdealPlace implements Serializable {
    float min_cena;
    float max_cena;
    float min_temperatura;
    float max_temperatura;
    int nocni_zivot;
    int urbanost;
    int[] najposeceniji_period_godine;
    Boolean dostupnost_gradskog_prevoza;
    int luksuz;
    Boolean vodene_povrsine;
    int hrana;
    Boolean skijalista;
    int [] priority;
}
