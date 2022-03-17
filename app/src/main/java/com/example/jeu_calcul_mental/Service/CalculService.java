package com.example.jeu_calcul_mental.Service;

import com.example.jeu_calcul_mental.database.CalculBaseHelper;
import com.example.jeu_calcul_mental.database.CalculDao;
import com.example.jeu_calcul_mental.entity.Calcul;

public class CalculService {
    private CalculDao calculDao;

    public CalculService(CalculDao calculDao) {
        this.calculDao = calculDao;
    }

    public long getCalculNumber(){
        return calculDao.count();
    }

    public void storeCalculInDatabase(Calcul calcul){
        calculDao.create(calcul);
    }
}
