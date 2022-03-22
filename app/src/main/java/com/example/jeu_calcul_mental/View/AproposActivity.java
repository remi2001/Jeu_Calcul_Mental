package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.jeu_calcul_mental.R;

public class AproposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);

        Button retourAccueilAPropos = findViewById(R.id.bouttonRetourAccueilAPropos);
        retourAccueilAPropos.setOnClickListener(view -> finish());
    }
}