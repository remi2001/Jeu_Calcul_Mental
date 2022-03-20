package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.Service.ScorePseudoService;
import com.example.jeu_calcul_mental.database.ScorePseudoBaseHelper;
import com.example.jeu_calcul_mental.database.ScorePseudoDao;
import com.example.jeu_calcul_mental.entity.ScorePseudo;
import com.google.android.material.textfield.TextInputEditText;

public class PseudoActivity extends AppCompatActivity {

    private TextView textViewScoreFinal;
    private TextInputEditText PseudoDefini;
    private Integer Score;
    private ScorePseudoService ScorePseudoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);
        ScorePseudoService = new ScorePseudoService(new ScorePseudoDao(new ScorePseudoBaseHelper(this)));

        Score = getIntent().getIntExtra("Score",0);

        textViewScoreFinal = findViewById(R.id.textViewScoreFinal);
        textViewScoreFinal.setText(Score.toString());

        PseudoDefini = findViewById(R.id.TextInputEditPseudo);

        Button boutonValider = findViewById(R.id.bouttonRetourAccueil);
        boutonValider.setOnClickListener(view -> Validation());
    }

    private void Validation(){
        try {
            int minScore = ScorePseudoService.getEnregistrement(ScorePseudoService.getEnregistrementNumber()-11).getScore();
            if (Score>0 && Score>minScore) {
                ScorePseudo registre = new ScorePseudo();
                registre.setPseudo(String.valueOf(PseudoDefini.getText()));
                registre.setScore(Score);
                ScorePseudoService.storeInDatabase(registre);
            }
        }
        catch (Exception e){
            if (Score>0) {
                ScorePseudo registre = new ScorePseudo();
                registre.setPseudo(String.valueOf(PseudoDefini.getText()));
                registre.setScore(Score);
                ScorePseudoService.storeInDatabase(registre);
            }
            //Gestion Score = 0 et Score trop petit page d'avant
        }
        finish();
        ouvreScoreActivity();
    }

    private void ouvreScoreActivity(){
        Intent i = new Intent(this, ScoreActivity.class);
        i.putExtra("Score",Score);
        i.putExtra("Pseudo",PseudoDefini.getText());
        startActivity(i);
    }
}