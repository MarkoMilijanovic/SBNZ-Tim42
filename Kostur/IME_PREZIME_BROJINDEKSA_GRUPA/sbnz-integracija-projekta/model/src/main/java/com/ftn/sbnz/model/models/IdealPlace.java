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
    int min_nocni_zivot;
    int max_nocni_zivot;
    int min_urbanost;
    int max_urbanost;
    int[] najposeceniji_period_godine;
    Boolean dostupnost_gradskog_prevoza;
    int min_luksuz;
    int max_luksuz;
    Boolean vodene_povrsine;
    int min_hrana;
    int max_hrana;
    Boolean skijalista;
}
