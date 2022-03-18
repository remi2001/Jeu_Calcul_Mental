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

public class ScoreActivity extends AppCompatActivity {

    private ScorePseudoService scorePseudoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        try {
            scorePseudoService = new ScorePseudoService(new ScorePseudoDao(new ScorePseudoBaseHelper(this)));
            ScorePseudo test = scorePseudoService.getEnregistrement();

            TextView pseudo1 = findViewById(R.id.NomJoueur1);
            TextView Score1 = findViewById(R.id.ScoreJoueur1);

            pseudo1.setText(test.getPseudo());
            Score1.setText(""+test.getScore());
        }catch(Exception e){}

        Button BouttonRetourAccueil = findViewById(R.id.bouttonRetourAccueil);
        BouttonRetourAccueil.setOnClickListener(view -> finish());
    }
}