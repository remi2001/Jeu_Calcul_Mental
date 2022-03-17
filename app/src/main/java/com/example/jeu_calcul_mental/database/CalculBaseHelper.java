package com.example.jeu_calcul_mental.database;

import android.content.Context;

public class CalculBaseHelper extends DataBaseHelper{

    public CalculBaseHelper(Context context) {
        super(context, "Calculs", 1);
    }

    @Override
    protected String getCreationSql() {
        String script = "CREATE TABLE IF NOT EXISTS historique (" +
                "id  INTEGER PRIMARY KEY AUTOINCREMENT," +
                CalculDao.Pseudo + " VARCHAR(255) NOT NULL,"+
                CalculDao.Score + " INTEGER NOT NULL" +
                ")";
        return script;
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
