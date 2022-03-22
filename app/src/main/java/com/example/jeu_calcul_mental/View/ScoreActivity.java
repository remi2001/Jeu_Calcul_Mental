package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.Service.ScorePseudoService;
import com.example.jeu_calcul_mental.database.ScorePseudoBaseHelper;
import com.example.jeu_calcul_mental.database.ScorePseudoDao;
import com.example.jeu_calcul_mental.entity.ScorePseudo;

import java.security.spec.ECField;
import java.util.Arrays;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    private ScorePseudoService scorePseudoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        try {
            scorePseudoService = new ScorePseudoService(new ScorePseudoDao(new ScorePseudoBaseHelper(this)));

            ScorePseudo dernierEnregistrement = scorePseudoService.getEnregistrementLastOrNull();

            ScorePseudo[] top10 = new ScorePseudo[10];

            List<ScorePseudo> listeTousElementBDD = scorePseudoService.getTousLesEnregistrement();

            int placementDernierEnregistrement = listeTousElementBDD.size();

            ScorePseudo[] TableauTousElementBDD = new ScorePseudo[listeTousElementBDD.size()];

            //Chaque element de la liste devient un element du tableau
            for(int i=0; i<listeTousElementBDD.size();i++) {
                TableauTousElementBDD[i] = listeTousElementBDD.get(i);
            }

            //Tri des elements
            ScorePseudo temporary;
            for (int parcoursBDD = 0; parcoursBDD < listeTousElementBDD.size(); parcoursBDD++) {
                for (int verifValBDD = parcoursBDD + 1; verifValBDD < listeTousElementBDD.size(); verifValBDD++) {
                    if (TableauTousElementBDD[verifValBDD].getScore() < TableauTousElementBDD[verifValBDD].getScore()) {
                        for (int decalElement=parcoursBDD; decalElement<verifValBDD;decalElement++) {
                            temporary = TableauTousElementBDD[decalElement];
                            TableauTousElementBDD[decalElement] = TableauTousElementBDD[verifValBDD];
                            TableauTousElementBDD[verifValBDD] = temporary;
                        }
                    }
                }
            }

            //Classement
            for(int ParcourClassement=0;ParcourClassement<10;ParcourClassement++){
                if(ParcourClassement<listeTousElementBDD.size())
                    top10[ParcourClassement] = TableauTousElementBDD[ParcourClassement];
            }

            TextView pseudo1 = findViewById(R.id.NomJoueur1);
            TextView score1 = findViewById(R.id.ScoreJoueur1);
            TextView pseudo2 = findViewById(R.id.NomJoueur2);
            TextView score2 = findViewById(R.id.ScoreJoueur2);
            TextView pseudo3 = findViewById(R.id.NomJoueur3);
            TextView score3 = findViewById(R.id.ScoreJoueur3);
            TextView pseudo4 = findViewById(R.id.NomJoueur4);
            TextView score4 = findViewById(R.id.ScoreJoueur4);
            TextView pseudo5 = findViewById(R.id.NomJoueur5);
            TextView score5 = findViewById(R.id.ScoreJoueur5);
            TextView pseudo6 = findViewById(R.id.NomJoueur6);
            TextView score6 = findViewById(R.id.ScoreJoueur6);
            TextView pseudo7 = findViewById(R.id.NomJoueur7);
            TextView score7 = findViewById(R.id.ScoreJoueur7);
            TextView pseudo8 = findViewById(R.id.NomJoueur8);
            TextView score8 = findViewById(R.id.ScoreJoueur8);
            TextView pseudo9 = findViewById(R.id.NomJoueur9);
            TextView score9 = findViewById(R.id.ScoreJoueur9);
            TextView pseudo10 = findViewById(R.id.NomJoueur10);
            TextView score10 = findViewById(R.id.ScoreJoueur10);

            TextView scoreDernierEnregistrement = findViewById(R.id.ScoreDernierEnregistrement);
            TextView pseudoDernierEnregistrement = findViewById(R.id.PseudoDernierEnregistrement);

            pseudoDernierEnregistrement.setText(dernierEnregistrement.getPseudo());
            scoreDernierEnregistrement.setText("" + dernierEnregistrement.getScore());

            pseudo1.setText(top10[0].getPseudo());
            score1.setText("" + top10[0].getScore());
            pseudo2.setText(top10[1].getPseudo());
            score2.setText("" + top10[1].getScore());
            pseudo3.setText(top10[2].getPseudo());
            score3.setText("" + top10[2].getScore());
            pseudo4.setText(top10[3].getPseudo());
            score4.setText("" + top10[3].getScore());
            pseudo5.setText(top10[4].getPseudo());
            score5.setText("" + top10[4].getScore());
            pseudo6.setText(top10[5].getPseudo());
            score6.setText("" + top10[5].getScore());
            pseudo7.setText(top10[6].getPseudo());
            score7.setText("" + top10[6].getScore());
            pseudo8.setText(top10[7].getPseudo());
            score8.setText("" + top10[7].getScore());
            pseudo9.setText(top10[8].getPseudo());
            score9.setText("" + top10[8].getScore());
            pseudo10.setText(top10[9].getPseudo());
            score10.setText("" + top10[9].getScore());

        }catch(Exception e){}

        Button BouttonRetourAccueil = findViewById(R.id.bouttonRetourAccueil);
        BouttonRetourAccueil.setOnClickListener(view -> finish());
    }
}