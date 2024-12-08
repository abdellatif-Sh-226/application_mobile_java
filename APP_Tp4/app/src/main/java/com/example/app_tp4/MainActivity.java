package com.example.app_tp4;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nomEditText, prenomEditText, emailEditText, telephoneEditText;
    private Button afficherButton, emailButton, siteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation d
        nomEditText = findViewById(R.id.nomEditText);
        prenomEditText = findViewById(R.id.prenomEditText);
        emailEditText = findViewById(R.id.emailEditText);
        telephoneEditText = findViewById(R.id.telephoneEditText);
        afficherButton = findViewById(R.id.afficherButton);
        emailButton = findViewById(R.id.emailButton);
        siteButton = findViewById(R.id.siteButton);

        // Bouton  d'aff"
        afficherButton.setOnClickListener(v -> {
            String nom = nomEditText.getText().toString();
            String prenom = prenomEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String telephone = telephoneEditText.getText().toString();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || telephone.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("nom", nom);
                intent.putExtra("prenom", prenom);
                intent.putExtra("email", email);
                intent.putExtra("telephone", telephone);
                startActivity(intent);
            }
        });

        // Bouton env
        emailButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            if (email.isEmpty()) {
                Toast.makeText(this, "Veuillez saisir une adresse e-mail.", Toast.LENGTH_SHORT).show();
            } else {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + email));
                startActivity(emailIntent);
            }
        });

        // Bouton web
        siteButton.setOnClickListener(v -> {
            Intent siteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
            startActivity(siteIntent);
        });
    }
}
