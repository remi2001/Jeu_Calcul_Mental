package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jeu_calcul_mental.R;

public class PseudoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);

        //Recuperation de la valeur du score
        Intent i = getIntent();
        Integer Score = i.getIntExtra("Score",0);

        TextView textViewScoreFinal = findViewById(R.id.textViewScoreFinal);
        textViewScoreFinal.setText(Score.toString());
    }
}