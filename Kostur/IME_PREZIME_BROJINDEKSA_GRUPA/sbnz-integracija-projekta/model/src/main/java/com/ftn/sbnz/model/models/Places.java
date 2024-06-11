package com.ftn.sbnz.model.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Places {
    private List<Place> places;
    public Places(){
        this.places = new ArrayList<>();
        this.places.add(new Place("Pariz", "Francuska", "Evropa", 200, 26, 9, 10, new int[]{11, 4}, true, 7, false, 6, false, new Score()));
        this.places.add(new Place("Moskva", "Rusija", "Azija", 10000, -30, 0, 5, new int[]{12, 1}, false, 9, false, 1, false, new Score()));
        this.places.add(new Place("Alanja", "Turska", "Asia", 120, 30, 7, 6, new int[]{6, 9}, true, 10, true, 9, false, new Score()));
        this.places.add(new Place("Beograd", "Srbija", "Evropa", 0, 0, 0, 0, new int[]{1, 2}, false, 0, false, 0, false, new Score()));
        this.places.add(new Place("Pariz", "Francuska", "Evropa", 200, 26, 9, 10, new int[]{11, 4}, true, 7, false, 6, false, new Score()));
        this.places.add(new Place("Pariz", "Francuska", "Evropa", 50, 26, 9, 10, new int[]{11, 4}, true, 7, false, 6, false, new Score()));
        this.places.add(new Place("Pariz", "Francuska", "Evropa", 200, 26, 9, 10, new int[]{11, 4}, true, 7, false, 6, false, new Score()));
        this.places.add(new Place("Pariz", "Francuska", "Evropa", 200, 26, 9, 10, new int[]{11, 4}, true, 7, false, 6, false, new Score()));
        this.places.add(new Place("Pariz", "Francuska", "Evropa", 200, 26, 9, 10, new int[]{11, 4}, true, 7, false, 6, false, new Score()));
        this.places.add(new Place("Pariz", "Francuska", "Evropa", 200, 26, 9, 10, new int[]{11, 4}, true, 7, false, 6, false, new Score()));
        for(int i = 0; i < this.places.size(); i++){
            this.places.get(i).getScore().reset();
        }
//        String naziv;
//        String zemlja;
//        String kontinent;
//        float prosecna_cena;
//        float prosecna_temperatura;
//        int nocni_zivot;
//        int urbanost;
//        int[] najposeceniji_period_godine;
//        Boolean dostupnost_gradskog_prevoza;
//        int luksuz;
//        Boolean vodene_povrsine;
//        int hrana;
//        Boolean skijalista;
    }
    public Place best(){
        Place best = this.places.get(0);
        for(int i = 1; i < this.places.size(); i++){
            if (this.places.get(i).getScore().calculateScore() > best.getScore().calculateScore()){
                best = this.places.get(i);
            }
        }
        return best;
    }
}
