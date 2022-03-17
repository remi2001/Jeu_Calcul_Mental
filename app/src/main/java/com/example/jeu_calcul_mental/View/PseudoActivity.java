package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeu_calcul_mental.R;
import com.example.jeu_calcul_mental.entity.Calcul;
import com.google.android.material.textfield.TextInputEditText;

public class PseudoActivity extends AppCompatActivity {

    private TextView textViewScoreFinal;
    private TextInputEditText PseudoDefini;
    private Integer Score = getIntent().getIntExtra("Score",0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudo);

        textViewScoreFinal = findViewById(R.id.textViewScoreFinal);
        textViewScoreFinal.setText(Integer.toString(Score));

        PseudoDefini = findViewById(R.id.TextInputEditPseudo);

        Button boutonValider = findViewById(R.id.bouttonValider);
        boutonValider.setOnClickListener(view -> Validation());
    }

    private void Validation(){
        Calcul calcul = new Calcul();
        calcul.setPseudo(PseudoDefini.getText().toString());
        calcul.setScore(Score);

        finish();
        ouvreScoreActivity();
    }

    private void ouvreScoreActivity(){
        Intent i = new Intent(this, ScoreActivity.class);
        startActivity(i);
    }
}