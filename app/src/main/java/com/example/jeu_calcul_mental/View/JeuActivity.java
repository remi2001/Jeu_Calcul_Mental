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
    private EnumOperation TypeOperation = EnumOperation.ADD;
    private Integer PremierElementCalcul = 0;
    private Integer DeuxiemeElementCalcul = 0;
    private final Random Aleat = new Random();

    private MenuItem NbScore;
    private MenuItem NbErreurs;
    private Integer Score=0;
    private Integer ErreursEncorePossible = 3;

    private boolean AjoutMoins=false;

    private TextView TextViewMauvaiseReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        TextViewCalcul = findViewById(R.id.textViewCalcul);
        TextViewResultat = findViewById(R.id.textViewReponse);
        TextViewMauvaiseReponse = findViewById(R.id.textViewMauvaiseReponse);
        TextViewMauvaiseReponse.setText("");

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
        NbScore = menu.findItem(R.id.NbScore);
        NbErreurs = menu.findItem(R.id.NbErreurs);

        return true;
    }

    //Vidage de la textViewResultat lorque l'on clique sur le bouton effacer et reinitialisation de la variable
    private void videTextViewResultat() {
        TextViewResultat.setText("");
        ElementResultat=0;
        AjoutMoins=false;
    }

    //Ajout de la valeur correpondant au bouton sur lequelle on a appuyer en gérant les valeurs trop grande
    private void AjoutValeurResultat(Integer valeur)
    {
        int borneMax = 99999;
        if(10*ElementResultat+valeur > borneMax){
            Toast.makeText(this,getString(R.string.ErreurTropGrande),Toast.LENGTH_LONG).show();
        }else {
            ElementResultat = 10 * ElementResultat + valeur;
        }
        majTextViewResultat();
    }

    //Mise a jour de la textViewREsultat lorsque la valeur de ElementResultat est modifier
    //Gestion des valeurs négative
    private void majTextViewResultat() {
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

    //Permet d'ajouter le calcul que l'utilisateur devra resoudre en generant les valeurs aleatoirement
    private void AjoutValeurCalcul() {
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
        String CalculAAfficher = PremierElementCalcul.toString() + " " +
                TypeOperation.getSymbol() + " " + DeuxiemeElementCalcul.toString();
        TextViewCalcul.setText(CalculAAfficher);
    }

    //Permet de vérifier que le nombre entré par l'utilisateur correspond au resultat du calcul
    //Si le nombre d'erreurs possible est inférieur a 0 on l'ance l'activité pemettant d'enrgistrer le score
    private void Verification(){
        if (AjoutMoins)
            ElementResultat = -ElementResultat;

        switch (TypeOperation){
            case ADD:
                if(PremierElementCalcul+DeuxiemeElementCalcul == ElementResultat){
                    ResultatCorrect();
                }
                else{
                    ResultatIncorrect();
                }
                break;
            case SUBSTRACT:
                if(PremierElementCalcul-DeuxiemeElementCalcul == ElementResultat){
                    ResultatCorrect();
                }
                else{
                    ResultatIncorrect();
                }
                break;
            case MULTIPLY:
                if(PremierElementCalcul*DeuxiemeElementCalcul == ElementResultat){
                    ResultatCorrect();
                }
                else{
                    ResultatIncorrect();
                }
                break;
        }
        if(ErreursEncorePossible==-1) {
            finish();

            //Lancement de l'activite Pseudo en fesant passer la valeur du score
            Intent i = new Intent(this, PseudoActivity.class);
            i.putExtra("Score",Score);
            startActivity(i);
        }
        videTextViewResultat();
        NbScore.setTitle(Score.toString());
        NbErreurs.setTitle(ErreursEncorePossible.toString());
    }

    //Ajout de la négativité dans le calcul uniquement si l'utilisateur n'a rien entré
    private void AjoutNegativite() {
        if(ElementResultat==0) {
            AjoutMoins=true;
            majTextViewResultat();
        }
        else{
            Toast.makeText(this,getString(R.string.ErreurMoins),Toast.LENGTH_LONG).show();
        }
    }

    //Action rélisé si le resultat du calcul correspond a la valeur entré par l'utilisateur
    private void ResultatCorrect(){
        Score += 10;
        AjoutValeurCalcul();
        TextViewMauvaiseReponse.setText("");
    }

    //Action rélisé si le resultat du calcul ne correspond pas a la valeur entré par l'utilisateur
    private void ResultatIncorrect(){
        if(TextViewResultat.getText()!="" && TextViewResultat.getText() != "-") {
            ErreursEncorePossible--;
            TextViewMauvaiseReponse.setText(R.string.ResultatIncorrect);
        }
        else{
            Toast.makeText(this,getString(R.string.ErreurValeurVide), Toast.LENGTH_LONG).show();
        }
    }
}