package com.example.jeu_calcul_mental;

public enum EnumOperation {
    ADD ("+"),
    SUBSTRACT ("-"),
    MULTIPLY ("x");

    private String symbol;

    EnumOperation(String s){
        this.symbol = s;
    }

    public String getSymbol() {
        return symbol;
    }
}

