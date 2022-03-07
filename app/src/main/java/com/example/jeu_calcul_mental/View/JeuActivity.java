package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeu_calcul_mental.R;

public class JeuActivity extends AppCompatActivity {

    private Integer premierElement = 0;
    private Integer secondElement = 0;
    private TextView TextViewResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        TextViewResultat = findViewById(R.id.textViewReponse);

        Button boutonZero = findViewById(R.id.boutton0);
        boutonZero.setOnClickListener(view -> AjoutValeur(0));


    }

    private void AjoutValeur(Integer valeur)
    {
        premierElement = 10 * premierElement + valeur;
        majTextView();
    }

    private void majTextView() {
        String textAAfficher="";
        textAAfficher = premierElement.toString();
        TextViewResultat.setText(textAAfficher);
    }
}