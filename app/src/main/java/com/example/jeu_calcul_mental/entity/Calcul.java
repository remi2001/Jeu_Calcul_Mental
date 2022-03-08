package com.example.jeu_calcul_mental.entity;

public class Calcul extends BaseEntity {


    Integer premierElement;
    Integer secondeElement;
    String symbole;
    Double resultat;


    public Integer getPremierElement() {
        return premierElement;
    }

    public Integer getDeuxiemeElement() {
        return secondeElement;
    }

    public String getSymbol() {
        return symbole;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setPremierElement(Integer premierElement) {
        this.premierElement = premierElement;
    }

    public void setDeuxiemeElement(Integer secondeElement) {
        this.secondeElement = secondeElement;
    }

    public void setSymbol(String symbole) {
        this.symbole = symbole;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }
}
