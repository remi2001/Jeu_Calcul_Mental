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

    public long getEnregistrementNumber(){return ScorePseudoDao.count();}

    public ScorePseudo getEnregistrement(long indiceEnregistrement){return ScorePseudoDao.RecuperationElement(indiceEnregistrement);}

    public List<ScorePseudo> getTousLesEnregistrement(){return ScorePseudoDao.RecuperationTousLesElement();}

    public void storeInDatabase(ScorePseudo ScorePseudo){ScorePseudoDao.create(ScorePseudo);}
}
