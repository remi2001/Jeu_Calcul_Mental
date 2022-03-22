package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.jeu_calcul_mental.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonJeu = findViewById(R.id.bouttonJeu);
        Button boutonScore = findViewById(R.id.bouttonScore);
        Button boutonAPropos = findViewById(R.id.bouttonAPropos);

        boutonJeu.setOnClickListener(view -> lanceActiviterJeu());
        boutonScore.setOnClickListener(view -> lancerActiviterScore());
        boutonAPropos.setOnClickListener(view -> lancerActiviterAPropos());
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

    private void lancerActiviterAPropos() {
        Intent i = new Intent(this, AproposActivity.class);
        startActivity(i);
    }
}