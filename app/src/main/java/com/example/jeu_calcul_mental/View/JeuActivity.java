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

    private Integer elementResultat = 0;
    private TextView textViewResultat;

    private TextView textViewCalcul;
    private EnumOperation typeOperation = EnumOperation.ADD;
    private Integer premierElementCalcul = 0;
    private Integer deuxiemeElementCalcul = 0;
    private final Random aleat = new Random();

    private MenuItem nbScore;
    private MenuItem nbErreurs;
    private Integer score=0;
    private Integer erreursEncorePossible = 3;

    private boolean ajoutMoins=false;

    private TextView textViewMauvaiseReponse;

    private int MargeAAjouter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        textViewCalcul = findViewById(R.id.textViewCalcul);
        textViewResultat = findViewById(R.id.textViewReponse);
        textViewMauvaiseReponse = findViewById(R.id.textViewMauvaiseReponse);
        textViewMauvaiseReponse.setText("");

        //Methode permettant de créer et d'afficher le calcul
        AjoutValeurCalcul();

        //Gestion des différents boutons
        Button boutonZero = findViewById(R.id.boutton0);
        boutonZero.setOnClickListener(view -> AjoutValeurResultat(0));

        Button boutonUn = findViewById(R.id.boutton1);
        boutonUn.setOnClickListener(view -> AjoutValeurResultat(1));

        Button boutonDeux = findViewById(R.id.boutton2);
        boutonDeux.setOnClickListener(view -> AjoutValeurResultat(2));

        Button boutonTrois = findViewById(R.id.boutton3);
        boutonTrois.setOnClickListener(view -> AjoutValeurResultat(3));

        Button boutonQuatre = findViewById(R.id.boutton4);
        boutonQuatre.setOnClickListener(view -> AjoutValeurResultat(4));

        Button boutonCinq = findViewById(R.id.boutton5);
        boutonCinq.setOnClickListener(view -> AjoutValeurResultat(5));

        Button boutonSix = findViewById(R.id.boutton6);
        boutonSix.setOnClickListener(view -> AjoutValeurResultat(6));

        Button boutonSept = findViewById(R.id.boutton7);
        boutonSept.setOnClickListener(view -> AjoutValeurResultat(7));

        Button boutonHuit = findViewById(R.id.boutton8);
        boutonHuit.setOnClickListener(view -> AjoutValeurResultat(8));

        Button boutonNeuf = findViewById(R.id.boutton9);
        boutonNeuf.setOnClickListener(view -> AjoutValeurResultat(9));

        Button boutonMoins = findViewById(R.id.bouttonMoins);
        boutonMoins.setOnClickListener(view -> AjoutNegativite());

        Button boutonEffacer = findViewById(R.id.bouttonEffacer);
        boutonEffacer.setOnClickListener(view->videTextViewResultat());

        Button boutonValider = findViewById(R.id.bouttonValider);
        boutonValider.setOnClickListener(view->Verification());
    }

    //toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);

        //Initialisation des item de la toolbar
        nbScore = menu.findItem(R.id.NbScore);
        nbErreurs = menu.findItem(R.id.NbErreurs);

        return true;
    }

    //Vidage de la textViewResultat lorque l'on clique sur le bouton effacer et reinitialisation de la variable
    private void videTextViewResultat() {
        textViewResultat.setText("");
        elementResultat=0;
        ajoutMoins=false;
    }

    //Ajout de la valeur correpondant au bouton sur lequelle on a appuyer en gérant les valeurs trop grande
    private void AjoutValeurResultat(Integer valeur)
    {
        int borneMax = 99999;
        if(10*elementResultat+valeur > borneMax){
            Toast.makeText(this,getString(R.string.ErreurTropGrande),Toast.LENGTH_LONG).show();
        }else {
            elementResultat = 10 * elementResultat + valeur;
        }
        majTextViewResultat();
    }

    //Mise a jour de la textViewREsultat lorsque la valeur de ElementResultat est modifier
    //Gestion des valeurs négative
    private void majTextViewResultat() {
        String textAAfficher="";
        if (ajoutMoins){
            if(elementResultat!=0)
                textAAfficher = "-" + elementResultat.toString();
            else
                textAAfficher = "-";
        }
        else{
            textAAfficher = elementResultat.toString();
        }
        textViewResultat.setText(textAAfficher);
    }

    //Permet d'ajouter le calcul que l'utilisateur devra resoudre en generant les valeurs aleatoirement
    private void AjoutValeurCalcul() {
        int choixTypeOperation = aleat.nextInt(4);
        switch(choixTypeOperation) {
            case 0:
                typeOperation = EnumOperation.ADD;
                break;
            case 1:
                typeOperation = EnumOperation.SUBSTRACT;
                break;
            case 2:
                typeOperation = EnumOperation.MULTIPLY;
                break;
        }
        if(typeOperation==EnumOperation.MULTIPLY){
            premierElementCalcul = aleat.nextInt(11+MargeAAjouter);
            deuxiemeElementCalcul = aleat.nextInt(11+MargeAAjouter);
        }
        else{
            premierElementCalcul = aleat.nextInt(101+(MargeAAjouter*100));
            deuxiemeElementCalcul = aleat.nextInt(101+(MargeAAjouter*100));
        }
        String CalculAAfficher = premierElementCalcul.toString() + " " +
                typeOperation.getSymbol() + " " + deuxiemeElementCalcul.toString();
        textViewCalcul.setText(CalculAAfficher);
    }

    //Permet de vérifier que le nombre entré par l'utilisateur correspond au resultat du calcul
    //Si le nombre d'erreurs possible est inférieur a 0 on l'ance l'activité pemettant d'enrgistrer le score
    private void Verification(){
        if (ajoutMoins)
            elementResultat = -elementResultat;

        switch (typeOperation){
            case ADD:
                if(premierElementCalcul+deuxiemeElementCalcul == elementResultat){
                    ResultatCorrect();
                }
                else{
                    ResultatIncorrect();
                }
                break;
            case SUBSTRACT:
                if(premierElementCalcul-deuxiemeElementCalcul == elementResultat){
                    ResultatCorrect();
                }
                else{
                    ResultatIncorrect();
                }
                break;
            case MULTIPLY:
                if(premierElementCalcul*deuxiemeElementCalcul == elementResultat){
                    ResultatCorrect();
                }
                else{
                    ResultatIncorrect();
                }
                break;
        }
        if(erreursEncorePossible==-1) {
            if(score>0) {
                erreursEncorePossible=0;
                finish();
                //Lancement de l'activite Pseudo en fesant passer la valeur du score
                Intent i = new Intent(this, PseudoActivity.class);
                i.putExtra("score", score);
                startActivity(i);
            }
            else{
                AjoutValeurCalcul();
                erreursEncorePossible=3;
                textViewMauvaiseReponse.setText(R.string.NonEnregistrerScore0);
            }
        }
        videTextViewResultat();
        nbScore.setTitle(score.toString());
        nbErreurs.setTitle(erreursEncorePossible.toString());
    }

    //Ajout de la négativité dans le calcul uniquement si l'utilisateur n'a rien entré
    private void AjoutNegativite() {
        if(elementResultat==0) {
            ajoutMoins=true;
            majTextViewResultat();
        }
        else{
            Toast.makeText(this,getString(R.string.ErreurMoins),Toast.LENGTH_LONG).show();
        }
    }

    //Action rélisé si le resultat du calcul correspond a la valeur entré par l'utilisateur
    private void ResultatCorrect(){
        score += 10;
        AjoutValeurCalcul();
        textViewMauvaiseReponse.setText("");
        if (MargeAAjouter<40){
            MargeAAjouter += 1;
        }
    }

    //Action rélisé si le resultat du calcul ne correspond pas a la valeur entré par l'utilisateur
    private void ResultatIncorrect(){
        if(textViewResultat.getText()!="" && textViewResultat.getText() != "-") {
            erreursEncorePossible--;
            textViewMauvaiseReponse.setText(R.string.ResultatIncorrect);
        }
        else{
            Toast.makeText(this,getString(R.string.ErreurValeurVide), Toast.LENGTH_LONG).show();
        }
    }
}