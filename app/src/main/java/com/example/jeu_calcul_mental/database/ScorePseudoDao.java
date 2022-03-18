package com.example.jeu_calcul_mental.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.jeu_calcul_mental.entity.ScorePseudo;


public class ScorePseudoDao extends BaseDao<ScorePseudo>{
    static String Pseudo = "pseudo";
    static String Score = "score";
    public ScorePseudoDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "historique";
    }

    @Override
    protected void putValues(ContentValues values, ScorePseudo entity) {
        values.put(Pseudo,entity.getPseudo());
        values.put(Score,entity.getScore());
    }

    @Override
    protected ScorePseudo getEntity(Cursor cursor) {
        cursor.moveToFirst();
        ScorePseudo ScorePseudo = new ScorePseudo();
        Integer indexPseudo = cursor.getColumnIndex(Pseudo);
        ScorePseudo.setPseudo(cursor.getString(indexPseudo));
        Integer indexScore = cursor.getColumnIndex(Score);
        ScorePseudo.setScore(cursor.getInt(indexScore));
        return ScorePseudo;
    }
}