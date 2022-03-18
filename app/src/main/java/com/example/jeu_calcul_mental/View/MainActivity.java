package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.Service.CalculService;
import com.example.jeu_calcul_mental.database.CalculBaseHelper;
import com.example.jeu_calcul_mental.database.CalculDao;

public class MainActivity extends AppCompatActivity {

    private CalculService calculService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculService = new CalculService(new CalculDao(new CalculBaseHelper(this)));

        Button boutonJeu = findViewById(R.id.bouttonJeu);
        Button boutonScore = findViewById(R.id.bouttonScore);

        boutonJeu.setOnClickListener(view -> lanceActiviterJeu());
        boutonScore.setOnClickListener(view -> lancerActiviterScore());
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
}