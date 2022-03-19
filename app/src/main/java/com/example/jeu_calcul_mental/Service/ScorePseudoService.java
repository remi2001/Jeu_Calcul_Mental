package com.example.jeu_calcul_mental.Service;

import com.example.jeu_calcul_mental.database.ScorePseudoDao;
import com.example.jeu_calcul_mental.entity.ScorePseudo;

import java.util.ArrayList;
import java.util.List;

public class ScorePseudoService {
    private ScorePseudoDao ScorePseudoDao;

    public ScorePseudoService(ScorePseudoDao calculDao) {
        this.ScorePseudoDao = calculDao;
    }

    public long getCalculNumber(){return ScorePseudoDao.count();}

    public ScorePseudo getDernierEnregistrement(){return ScorePseudoDao.lastOrNull();}

    public ScorePseudo getEnregistrement(int indiceEnregistrement){return ScorePseudoDao.RecuperationElement(indiceEnregistrement);}

    public void storeInDatabase(ScorePseudo ScorePseudo){ScorePseudoDao.create(ScorePseudo);}
}
