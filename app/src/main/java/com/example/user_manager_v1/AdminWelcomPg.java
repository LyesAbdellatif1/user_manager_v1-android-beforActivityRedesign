package com.example.user_manager_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminWelcomPg extends AppCompatActivity {


    private Button buttonadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_welcom_pg);
        buttonadmin = (Button) findViewById(R.id.sign_in_btnadmin);
        buttonadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AdminWelcomPg.this, EmployeeListActivity.class);
                startActivity(intent);

            }
        });



    }


}