package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.Service.ScorePseudoService;
import com.example.jeu_calcul_mental.database.ScorePseudoBaseHelper;
import com.example.jeu_calcul_mental.database.ScorePseudoDao;
import com.example.jeu_calcul_mental.entity.ScorePseudo;

import java.security.spec.ECField;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    private ScorePseudoService scorePseudoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        try {
            scorePseudoService = new ScorePseudoService(new ScorePseudoDao(new ScorePseudoBaseHelper(this)));

            ScorePseudo[] Top10 = new ScorePseudo[10];

            for(int initialise=0;initialise<10;initialise++){
                Top10[initialise]= scorePseudoService.getEnregistrement(0);
            }

            for (int parcourBdd=1;parcourBdd<scorePseudoService.getCalculNumber();parcourBdd++) {
                ScorePseudo Temp = scorePseudoService.getEnregistrement(parcourBdd);
                if(Temp.getScore() > Top10[0].getScore())
                {
                     Top10[0] = Temp;
                }
            }

            for (int ParcourClassement=1;ParcourClassement<10;ParcourClassement++){
                for (int parcourBdd=1;parcourBdd<scorePseudoService.getCalculNumber();parcourBdd++) {
                    ScorePseudo Temp = scorePseudoService.getEnregistrement(parcourBdd);
                    for(int VerifClassemntSup=ParcourClassement;VerifClassemntSup>=0;VerifClassemntSup--) {
                        if (Temp.getScore() > Top10[ParcourClassement].getScore() && Temp != Top10[ParcourClassement - VerifClassemntSup]) {
                            Top10[0] = Temp;
                        }
                    }
                }
            }

            TextView pseudo1 = findViewById(R.id.NomJoueur1);
            TextView Score1 = findViewById(R.id.ScoreJoueur1);

            pseudo1.setText(Top10[0].getPseudo());
            Score1.setText("" + Top10[0].getScore());
        }catch(Exception e){}

        Button BouttonRetourAccueil = findViewById(R.id.bouttonRetourAccueil);
        BouttonRetourAccueil.setOnClickListener(view -> finish());
    }
}