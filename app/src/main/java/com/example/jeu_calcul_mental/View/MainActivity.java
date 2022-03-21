package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.Service.ScorePseudoService;
import com.example.jeu_calcul_mental.database.ScorePseudoBaseHelper;
import com.example.jeu_calcul_mental.database.ScorePseudoDao;

public class MainActivity extends AppCompatActivity {

    private ScorePseudoService scorePseudoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scorePseudoService = new ScorePseudoService(new ScorePseudoDao(new ScorePseudoBaseHelper(this)));

        Button boutonJeu = findViewById(R.id.bouttonJeu);
        Button boutonScore = findViewById(R.id.bouttonScore);
        Button boutonFonctionnalite = findViewById(R.id.bouttonFonctionnalite);

        boutonJeu.setOnClickListener(view -> lanceActiviterJeu());
        boutonScore.setOnClickListener(view -> lancerActiviterScore());
        boutonFonctionnalite.setOnClickListener(view -> lancerActiviterFonctionnalites());
    }

    //Lancement de l'activite Jeu
    private void lanceActiviterJeu() {
        Intent i = new Intent(this, JeuActivity.class);
        startActivity(i);
    }

    //lancement de l'activite Score
    private void lancerActiviterScore() {
        Intent i = new Intent(this, ScoreActivity.class);
        startActivity(i);
    }

    private void lancerActiviterFonctionnalites() {
        Intent i = new Intent(this, FonctionnaliteActivity.class);
        startActivity(i);
    }
}