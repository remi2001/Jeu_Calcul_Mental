package com.example.jeu_calcul_mental.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.jeu_calcul_mental.entity.Calcul;


public class CalculDao extends BaseDao<Calcul>{
    static String Pseudo = "pseudo";
    static String Score = "score";
    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "historique";
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(Pseudo,entity.getPseudo());
        values.put(Score,entity.getScore());
    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        cursor.moveToFirst();
        Calcul calcul = new Calcul();
        Integer indexPseudo = cursor.getColumnIndex(Pseudo);
        calcul.setPseudo(cursor.getString(indexPseudo));
        Integer indexScore = cursor.getColumnIndex(Score);
        calcul.setScore(cursor.getInt(indexScore));
        return calcul;
    }
}