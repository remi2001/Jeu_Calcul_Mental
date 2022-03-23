package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.Service.ScorePseudoService;
import com.example.jeu_calcul_mental.database.ScorePseudoBaseHelper;
import com.example.jeu_calcul_mental.database.ScorePseudoDao;
import com.example.jeu_calcul_mental.entity.ScorePseudo;
import com.google.android.material.textfield.TextInputEditText;

public class PseudoActivity extends AppCompatActivity {

    private TextView textViewScoreFinal;
    private TextInputEditText pseudoDefini;
    private Integer score;
    private ScorePseudoService scorePseudoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);
        scorePseudoService = new ScorePseudoService(new ScorePseudoDao(new ScorePseudoBaseHelper(this)));

        score = getIntent().getIntExtra("score",0);

        textViewScoreFinal = findViewById(R.id.textViewScoreFinal);
        textViewScoreFinal.setText(score.toString());

        pseudoDefini = findViewById(R.id.TextInputEditPseudo);
        pseudoDefini.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        Button boutonValider = findViewById(R.id.bouttonRetourAccueil);
        boutonValider.setOnClickListener(view -> Validation());
    }

    private void Validation(){
        if(pseudoDefini.getText().toString().matches("")){
            Toast.makeText(this, getString(R.string.pseudovide), Toast.LENGTH_LONG).show();
        }else {
            ScorePseudo registre = new ScorePseudo();
            registre.setPseudo(String.valueOf(pseudoDefini.getText()));
            registre.setScore(score);
            scorePseudoService.storeInDatabase(registre);
            ouvreScoreActivity();
            finish();
        }
    }

    private void ouvreScoreActivity(){
        Intent i = new Intent(this, ScoreActivity.class);
        startActivity(i);
    }
}