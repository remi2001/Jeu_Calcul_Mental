package com.example.jeu_calcul_mental.Service;

import com.example.jeu_calcul_mental.database.ScorePseudoDao;
import com.example.jeu_calcul_mental.entity.ScorePseudo;

import java.util.ArrayList;

public class ScorePseudoService {
    private ScorePseudoDao ScorePseudoDao;

    public ScorePseudoService(ScorePseudoDao calculDao) {
        this.ScorePseudoDao = calculDao;
    }

    public long getCalculNumber(){return ScorePseudoDao.count();}

    public ScorePseudo getEnregistrement(){return ScorePseudoDao.lastOrNull();}

    public void storeInDatabase(ScorePseudo ScorePseudo){
        ScorePseudoDao.create(ScorePseudo);
    }
}
