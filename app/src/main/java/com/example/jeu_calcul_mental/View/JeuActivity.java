package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeu_calcul_mental.R;

public class JeuActivity extends AppCompatActivity {

    private Integer premierElement = 0;
    //private Integer secondElement = 0;
    private TextView TextViewResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        TextViewResultat = findViewById(R.id.textViewReponse);

        Button boutonZero = findViewById(R.id.boutton0);
        boutonZero.setOnClickListener(view -> AjoutValeur(0));

        Button boutonUn = findViewById(R.id.boutton1);
        boutonUn.setOnClickListener(view -> AjoutValeur(1));

        Button boutonDeux = findViewById(R.id.boutton2);
        boutonDeux.setOnClickListener(view -> AjoutValeur(2));

        Button boutonTrois = findViewById(R.id.boutton3);
        boutonTrois.setOnClickListener(view -> AjoutValeur(3));

        Button boutonQuatre = findViewById(R.id.boutton4);
        boutonQuatre.setOnClickListener(view -> AjoutValeur(4));

        Button boutonCinq = findViewById(R.id.boutton5);
        boutonCinq.setOnClickListener(view -> AjoutValeur(5));

        Button boutonSix = findViewById(R.id.boutton6);
        boutonSix.setOnClickListener(view -> AjoutValeur(6));

        Button boutonSept = findViewById(R.id.boutton7);
        boutonSept.setOnClickListener(view -> AjoutValeur(7));

        Button boutonHuit = findViewById(R.id.boutton8);
        boutonHuit.setOnClickListener(view -> AjoutValeur(8));

        Button boutonNeuf = findViewById(R.id.boutton9);
        boutonNeuf.setOnClickListener(view -> AjoutValeur(9));

        Button boutonEffacer = findViewById(R.id.bouttonEffacer);
        boutonEffacer.setOnClickListener(view->videTextView());

        Button boutonValider = findViewById(R.id.bouttonValider);
        //boutonValider.setOnClickListener(view->);

    }

    private boolean videTextView() {
        TextViewResultat.setText("");
        premierElement=0;
        return true;
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