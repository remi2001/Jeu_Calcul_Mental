package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.entity.Calcul;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String pseudo = getIntent().getStringExtra("Pseudo");
        Integer score = getIntent().getIntExtra("Score",0);

        TextView pseudo1 = findViewById(R.id.NomPremierJoueur);
        pseudo1.setText(/*calcul.getPseudo()*/pseudo);

        TextView Score1 = findViewById(R.id.ScorePremierJoueur);
        Score1.setText(/*""+calcul.getScore()*/""+score);
    }
}