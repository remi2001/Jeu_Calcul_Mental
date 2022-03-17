package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.Service.CalculService;
import com.example.jeu_calcul_mental.database.CalculBaseHelper;
import com.example.jeu_calcul_mental.database.CalculDao;
import com.example.jeu_calcul_mental.entity.Calcul;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String calcul = getIntent().getStringExtra("calcul");

        TextView pseudo1 = findViewById(R.id.NomJoueur1);
        pseudo1.setText(calcul);

        TextView Score1 = findViewById(R.id.ScoreJoueur1);
        //Score1.setText(""+calculService.getScore());

        Button BouttonRetourAccueil = findViewById(R.id.bouttonRetourAccueil);
        BouttonRetourAccueil.setOnClickListener(view -> finish());
    }
}