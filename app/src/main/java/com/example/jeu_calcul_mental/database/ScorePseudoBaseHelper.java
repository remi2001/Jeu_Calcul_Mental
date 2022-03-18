package com.example.jeu_calcul_mental.database;

import android.content.Context;

public class ScorePseudoBaseHelper extends DataBaseHelper{

    public ScorePseudoBaseHelper(Context context) {
        super(context, "Calculs", 1);
    }

    @Override
    protected String getCreationSql() {
        String script = "CREATE TABLE IF NOT EXISTS historique (" +
                "id  INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScorePseudoDao.Pseudo + " VARCHAR(255) NOT NULL,"+
                ScorePseudoDao.Score + " INTEGER NOT NULL" +
                ")";
        return script;
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
