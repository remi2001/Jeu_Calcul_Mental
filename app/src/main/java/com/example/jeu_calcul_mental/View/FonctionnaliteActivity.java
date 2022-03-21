package com.example.jeu_calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.jeu_calcul_mental.R;

public class FonctionnaliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fonctionnalite);

        Button RetourAccueil = findViewById(R.id.bouttonRetourAccueil);
        RetourAccueil.setOnClickListener(view -> finish());
    }
}