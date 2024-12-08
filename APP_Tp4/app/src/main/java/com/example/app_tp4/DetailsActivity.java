package com.example.app_tp4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private TextView nomTextView, prenomTextView, emailTextView, telephoneTextView;
    private Button retourButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // Initialisation
        nomTextView = findViewById(R.id.nomTextView);
        prenomTextView = findViewById(R.id.prenomTextView);
        emailTextView = findViewById(R.id.emailTextView);
        telephoneTextView = findViewById(R.id.telephoneTextView);
        retourButton = findViewById(R.id.retourButton);

        // Récupération
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String prenom = intent.getStringExtra("prenom");
        String email = intent.getStringExtra("email");
        String telephone = intent.getStringExtra("telephone");

        // Affichage
        nomTextView.setText("Nom : " + nom);
        prenomTextView.setText("Prénom : " + prenom);
        emailTextView.setText("Email : " + email);
        telephoneTextView.setText("Téléphone : " + telephone);


        retourButton.setOnClickListener(v -> finish());
    }
}
