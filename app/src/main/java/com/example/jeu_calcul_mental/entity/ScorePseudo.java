package com.example.jeu_calcul_mental.entity;

public class ScorePseudo extends BaseEntity{

    private String Pseudo="";
    private Integer Score=0;

    public String getPseudo() {
        return Pseudo;
    }

    public Integer getScore() {
        return Score;
    }

    public void setPseudo(String Pseudo) {
        this.Pseudo = Pseudo;
    }

    public void setScore(Integer Score) {
        this.Score = Score;
    }
}