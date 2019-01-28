package main.java.model;

import java.util.*;

public class Joueur {
    private static final int NBMOUVEMENT = 20;
    private final String nom;
    private int score;
    private List<RPSEnum> listMouvements = new ArrayList<>();

    public Joueur(String nom){
        this.nom = nom;
        for(int i=0;i<NBMOUVEMENT;i++){
            int n = new Random().nextInt(3);
            listMouvements.add(RPSEnum.values()[n]);
        }
    }

    public Joueur(String nom, List<RPSEnum> listMouvements) {
        this.nom = nom;
        this.listMouvements = listMouvements;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getNBMOUVEMENT() {
        return NBMOUVEMENT;
    }

    public RPSEnum getNextMove(){

        return listMouvements.remove(0);
    }
}
