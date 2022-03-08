package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeu_calcul_mental.EnumOperation;
import com.example.jeu_calcul_mental.R;

import java.util.zip.Inflater;

public class JeuActivity extends AppCompatActivity {

    private Integer ElementResultat = 0;
    private TextView TextViewResultat;

    private TextView TextViewCalcul;
    private Integer premierElement = 0;
    private Integer secondElement = 0;
    private Integer BORNE_MAX=9999;
    private EnumOperation TypeOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        TextViewCalcul = findViewById(R.id.textViewCalcul);
        AjoutValeurCalcul();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return true;
    }

    private boolean videTextView() {
        TextViewResultat.setText("");
        ElementResultat=0;
        return true;
    }

    private void AjoutValeur(Integer valeur)
    {
        ElementResultat = 10 * ElementResultat + valeur;
        majTextView();
    }

    private void AjoutValeurCalcul(){
        premierElement = (int) Math.random()*(100-0);
        int nb = (int) Math.random()*(4-0);
        //switch case
        secondElement = (int) Math.random()*(100-0);
        majTextView();
    }



    private void majTextView() {
        String textAAfficher="";
        textAAfficher = ElementResultat.toString();
        TextViewResultat.setText(textAAfficher);
    }
}