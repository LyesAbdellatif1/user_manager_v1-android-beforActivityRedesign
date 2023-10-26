package com.example.user_manager_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tv_first_name, tv_last_name, tv_email,tv_Montant_des_imaye;
    Button sign_out_btn;
    Button sign_out_btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Hook Text View Objects:
        tv_first_name = findViewById(R.id.Montant_des_imayes10);
        tv_last_name = findViewById(R.id.last_name);
        tv_email = findViewById(R.id.email);
        tv_Montant_des_imaye = findViewById(R.id.Montant_des_imaye);


        // Get Intent Extra Values:
        String first_name = getIntent().getStringExtra("first_name");
        String last_name = getIntent().getStringExtra("last_name");
        String email = getIntent().getStringExtra("email");
        Double Montant_des_imaye = getIntent().getDoubleExtra("montant_des_imayes", 0.0); // Use 0.0 as the default value
//Montant_des_imayes

        // Set Text View Profile Values:
        tv_first_name.setText(first_name);
        tv_last_name.setText(last_name);
        tv_email.setText(email);
        // Convert the Double to a String
        String textToDisplay = String.valueOf(Montant_des_imaye);
        // Set the text in the TextView
        tv_Montant_des_imaye.setText(textToDisplay);


        // Hook Sign Out Button:
        sign_out_btn = findViewById(R.id.mes_relance);
        sign_out_btn3 = findViewById(R.id.hayalbouton);

        sign_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUserOut();
            }
        });



        // Set On Click Listener:
        sign_out_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAccueil2();
            }
        });
    }

    public void signUserOut(){

        // Set Text View Profile Values:
        tv_first_name.setText(null);
        tv_last_name.setText(null);
        tv_email.setText(null);

        // Return User Back To Home:
        Intent goToHome = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(goToHome);
        finish();

    }
    public void gotoAccueil2(){


        // Return User Back To Home:
        Intent goToHome = new Intent(ProfileActivity.this, acceuil2.class);
        startActivity(goToHome);
        finish();

    }
}