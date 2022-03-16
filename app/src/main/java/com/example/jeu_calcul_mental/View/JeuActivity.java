package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeu_calcul_mental.EnumOperation;
import com.example.jeu_calcul_mental.R;

import java.util.Random;

public class JeuActivity extends AppCompatActivity {

    private Integer ElementResultat = 0;
    private TextView TextViewResultat;

    private TextView TextViewCalcul;
    private EnumOperation TypeOperation;
    private Integer PremierElementCalcul = 0;
    private Integer DeuxiemeElementCalcul = 0;
    private final Random Aleat = new Random();
    private MenuItem NbScore;
    private MenuItem NbErreurs;
    private Integer Score=0;
    private Integer ErreursEncorePossible = 3;
    private boolean AjoutMoins=false;

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

        Button boutonMoins = findViewById(R.id.bouttonMoins);
        boutonMoins.setOnClickListener(view -> AjoutNegativite());

        Button boutonEffacer = findViewById(R.id.bouttonEffacer);
        boutonEffacer.setOnClickListener(view->videTextViewReponse());

        Button boutonValider = findViewById(R.id.bouttonValider);
        boutonValider.setOnClickListener(view->Verification());
    }

    //toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);

        NbScore = menu.findItem(R.id.NbScore);
        NbErreurs = menu.findItem(R.id.NbErreurs);
        return true;
    }

    //Vidage de la textViewReponse lorque l'on clique sur le bouton effacer
    private void videTextViewReponse() {
        TextViewResultat.setText("");
        ElementResultat=0;
        AjoutMoins=false;
    }

    //Ajout de la valeur correpondant au bouton sur lequelle on appuyer
    private void AjoutValeurReponse(Integer valeur)
    {
        int borneMax = 99999;
        if(10*ElementResultat+valeur > borneMax){
            Toast.makeText(this,getString(R.string.ErreurTropGrande),Toast.LENGTH_LONG).show();
        }else {
            ElementResultat = 10 * ElementResultat + valeur;
        }
        majTextViewReponse();
    }

    //Mise a jour du textViewReponse lorsque la valeur est modifier
    private void majTextViewReponse() {
        String textAAfficher="";
        if (AjoutMoins){
            if(ElementResultat!=0)
                textAAfficher = "-" + ElementResultat.toString();
            else
                textAAfficher = "-";
        }
        else{
            textAAfficher = ElementResultat.toString();
        }
        TextViewResultat.setText(textAAfficher);
    }

    //Permmettant d'ajouter une valeur
    private void AjoutValeurCalcul() {
        String CalculAAfficher = "";
        PremierElementCalcul = Aleat.nextInt(101);
        DeuxiemeElementCalcul = Aleat.nextInt(101);
        int choixTypeOperation = Aleat.nextInt(4);
        switch(choixTypeOperation) {
            case 0:
                TypeOperation = EnumOperation.ADD;
                break;
            case 1:
                TypeOperation = EnumOperation.SUBSTRACT;
                break;
            case 2:
                TypeOperation = EnumOperation.MULTIPLY;
                break;
        }
        CalculAAfficher = PremierElementCalcul.toString() + " " +
                TypeOperation.getSymbol() + " " + DeuxiemeElementCalcul.toString();
        TextViewCalcul.setText(CalculAAfficher);
    }

    private void Verification(){
        if (AjoutMoins)
            ElementResultat = -ElementResultat;

        switch (TypeOperation){
            case ADD:
                if(PremierElementCalcul+DeuxiemeElementCalcul == ElementResultat){
                    Score += 10;
                    AjoutValeurCalcul();
                }
                else{
                    ErreursEncorePossible--;
                    Toast.makeText(this,getString(R.string.ErreurCalcul),Toast.LENGTH_LONG).show();
                }
                break;
            case SUBSTRACT:
                if(PremierElementCalcul-DeuxiemeElementCalcul == ElementResultat){
                    Score += 10;
                    AjoutValeurCalcul();
                }
                else{
                    ErreursEncorePossible--;
                    Toast.makeText(this,getString(R.string.ErreurCalcul),Toast.LENGTH_LONG).show();
                }
                break;
            case MULTIPLY:
                if(PremierElementCalcul*DeuxiemeElementCalcul == ElementResultat){
                    Score += 10;
                    AjoutValeurCalcul();
                }
                else{
                    ErreursEncorePossible--;
                    Toast.makeText(this,getString(R.string.ErreurCalcul),Toast.LENGTH_LONG).show();
                }
                break;
        }
        if(ErreursEncorePossible==-1) {
            finish();
            Intent i = new Intent(this, PseudoActivity.class);
            i.putExtra("Score",Score);
            startActivity(i);
        }
        videTextViewReponse();
        NbScore.setTitle(Score.toString());
        NbErreurs.setTitle(ErreursEncorePossible.toString());
    }

    private void AjoutNegativite() {
        if(ElementResultat==0) {
            AjoutMoins=true;
            majTextViewReponse();
        }
        else{
            Toast.makeText(this,getString(R.string.ErreurMoins),Toast.LENGTH_LONG).show();
        }
    }
}