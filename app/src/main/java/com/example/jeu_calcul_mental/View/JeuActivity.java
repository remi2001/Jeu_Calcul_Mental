package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeu_calcul_mental.R;

import java.util.Random;

public class JeuActivity extends AppCompatActivity {

    private Integer ElementResultat = 0;
    private Integer BorneMax=999999999;
    private TextView TextViewResultat;

    private TextView TextViewCalcul;
    private final Random Aleat = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        TextViewCalcul = findViewById(R.id.textViewCalcul);
        TextViewResultat = findViewById(R.id.textViewReponse);

        AjoutValeurCalcul();

        Button boutonZero = findViewById(R.id.boutton0);
        boutonZero.setOnClickListener(view -> AjoutValeurReponse(0));

        Button boutonUn = findViewById(R.id.boutton1);
        boutonUn.setOnClickListener(view -> AjoutValeurReponse(1));

        Button boutonDeux = findViewById(R.id.boutton2);
        boutonDeux.setOnClickListener(view -> AjoutValeurReponse(2));

        Button boutonTrois = findViewById(R.id.boutton3);
        boutonTrois.setOnClickListener(view -> AjoutValeurReponse(3));

        Button boutonQuatre = findViewById(R.id.boutton4);
        boutonQuatre.setOnClickListener(view -> AjoutValeurReponse(4));

        Button boutonCinq = findViewById(R.id.boutton5);
        boutonCinq.setOnClickListener(view -> AjoutValeurReponse(5));

        Button boutonSix = findViewById(R.id.boutton6);
        boutonSix.setOnClickListener(view -> AjoutValeurReponse(6));

        Button boutonSept = findViewById(R.id.boutton7);
        boutonSept.setOnClickListener(view -> AjoutValeurReponse(7));

        Button boutonHuit = findViewById(R.id.boutton8);
        boutonHuit.setOnClickListener(view -> AjoutValeurReponse(8));

        Button boutonNeuf = findViewById(R.id.boutton9);
        boutonNeuf.setOnClickListener(view -> AjoutValeurReponse(9));

        Button boutonEffacer = findViewById(R.id.bouttonEffacer);
        boutonEffacer.setOnClickListener(view->videTextViewReponse());

        Button boutonValider = findViewById(R.id.bouttonValider);
        //boutonValider.setOnClickListener(view->Verification());
    }

    //toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);

        //NbScore = menu.findItem(R.id.NbScore);
        return true;
    }

    //Vidage de la textViewReponse lorque l'on clique sur le bouton effacer
    private boolean videTextViewReponse() {
        TextViewResultat.setText("");
        ElementResultat=0;
        return true;
    }

    //Ajout de la valeur correpondant au bouton sur lequelle on appuyer
    private void AjoutValeurReponse(Integer valeur)
    {
        if(10*ElementResultat+valeur > BorneMax){
            Toast.makeText(this,getString(R.string.ErreurTropGrande),Toast.LENGTH_LONG).show();
        }else {
            ElementResultat = 10 * ElementResultat + valeur;
        }
        majTextViewReponse();
    }

    //Mise a jour du textViewReponse lorsque la valeur est modifier
    private void majTextViewReponse() {
        String textAAfficher="";
        textAAfficher = ElementResultat.toString();
        TextViewResultat.setText(textAAfficher);
    }

    //Permmettant d'ajouter une valeur
    private void AjoutValeurCalcul() {
        TextViewCalcul.setText("test");
    }
}