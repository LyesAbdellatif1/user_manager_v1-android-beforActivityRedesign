package com.example.user_manager_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.user_manager_v1.helpers.StringHelper;
import com.example.user_manager_v1.ui.home.HomeFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SignInActivity extends AppCompatActivity {

    Button sign_in_btn;
    EditText et_email, et_password,et_ID;
    private String out;
    private Bundle results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Hook Edit Text Fields:
        et_email = findViewById(R.id.email);
        et_password = findViewById(R.id.password);
        et_ID = findViewById(R.id.id_id);

        // Hook Button:
        sign_in_btn = findViewById(R.id.sign_in_btnadmin);

        // Set Sign In Button On Click Listener:
        sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticateUser();
            }
        });

    }
    // End Of On Create Activity.

    public void authenticateUser(){
        // Check For Errors:
        if( !validateEmail() || !validatePassword()){
            return;
        }
        // End Of Check For Errors.

        // Instantiate The Request Queue:
        RequestQueue queue = Volley.newRequestQueue(SignInActivity.this);
        // The URL Posting TO:
        String url = "http://192.168.1.10:8083/api/v1/user/login";  // 192.168.1.10 "http://172.20.10.2:9080/api/v1/user/login";

        // Set Parameters:
        HashMap<String, String> params = new HashMap<String, String>();
       // params.put("email", et_email.getText().toString());
        params.put("password", et_password.getText().toString());
        params.put("email", et_email.getText().toString());
        params.put("user_id", et_ID.getText().toString());

        // Set Request Object:
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Get Values From Response Object:
                            String first_name = (String) response.get("first_name");
                            String last_name = (String) response.get("last_name");
                            String email = (String) response.get("email");
                            Double montant_des_imayes = (Double) response.get("montant_des_imayes");


                            // Set Intent Actions:
                            Intent goToProfile = new Intent(SignInActivity.this, ProfileActivity.class);
                            //Intent goToHomeFragment = new Intent(SignInActivity.this, HomeFragment.class);
                            // Pass Values To Profile Activity:
                            goToProfile.putExtra("first_name", first_name);
                            goToProfile.putExtra("last_name", last_name);
                            goToProfile.putExtra("email", email);
                            //goToProfile.putExtra("montant_des_imayes", montant_des_imayes);
                            Log.d("lyeslyes14", "montant_des_imayes in HomeFragment: " + montant_des_imayes);



                            // Start Activity:
                            startActivity(goToProfile);
                            finish();
                        }catch (JSONException e){
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                        }
                        // End Of Try Block.
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                System.out.println(error.getMessage());
                Toast.makeText(SignInActivity.this, "Login Failed !", Toast.LENGTH_LONG).show();
            }
        });// End Of Set Request Object.

        queue.add(jsonObjectRequest);

    }




    public void goToHome(View view){
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    // End Of Go To Home Intent Method.


    public void goToSigUpAct(View view){
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    // End Of Go To Sign Up Intent Method.


    public boolean validateEmail(){
        String email = et_email.getText().toString();
        // Check If Email Is Empty:
        if(email.isEmpty()){
            et_email.setError("Email cannot be empty!");
            return false;
        }else if(!StringHelper.regexEmailValidationPattern(email)){
            et_email.setError("Please enter a valid email");
            return false;
        }else{
            et_email.setError(null);
            return true;
        }// Check If Email Is Empty.
    }
    // End Of Validate Email Field.

    public boolean validatePassword() {
        String password = et_password.getText().toString();

        // Check If Password and Confirm Field Is Empty:
        if (password.isEmpty()) {
            et_password.setError("Password cannot be empty!");
            return false;
        } else {
            et_password.setError(null);
            return true;
        }// Check Password and Confirm Field Is Empty.
    }

    public void goToAdmin(View view) {
        Intent intent = new Intent(SignInActivity.this, AdminWelcomPg.class);
        startActivity(intent);
        finish();

    }

    // End Of Validate Password;
}
// End Of Sign In Activity Class.


 /*

        Intent intent = getIntent();
        out = intent.getExtras().getString("Key");

         */
    /*
 public Bundle getMyData() {
     Bundle hm = new Bundle();
     hm.putString("val1",out);
     return hm;
 }*/
//goToHomeFragment.putExtra("montant_des_imayes", montant_des_imayes);

// In your SignInActivity
                            /*HomeFragment homeFragment = new HomeFragment();
                            Bundle args = new Bundle();
                            args.putDouble("montant_des_imayes", montant_des_imayes);
                            homeFragment.setArguments(args);*/



// Create a new instance of HomeFragment and pass the data as arguments
// Create a new instance of HomeFragment and pass the data as arguments
                           /* HomeFragment homeFragment = new HomeFragment();
                            Bundle args = new Bundle();
                            args.putDouble("montant_des_imayes", montant_des_imayes);
                            homeFragment.setArguments(args);
                           // Log.d("Activity1002", "HomeFragment created with montant_des_imayes: " + montant_des_imayes);
                            // Detach and attach the HomeFragment
                            getSupportFragmentManager().beginTransaction().detach(homeFragment).attach(homeFragment).commit();
                            //Log.d("Activity1002", "HomeFragment detached and attached");
                            */
                           /* Bundle bundle=new Bundle();
                            bundle.putString("name", "From Activity");
                            //set Fragmentclass Arguments
                            HomeFragment fragobj=new HomeFragment();
                            fragobj.setArguments(bundle);*/
                            /*
                            Bundle bundle = new Bundle();
                            String myMessage = "Stackoverflow is cool!";
                            bundle.putString("message", myMessage );
                            HomeFragment fragInfo = new HomeFragment();
                            fragInfo.setArguments(bundle);
                            transaction.replace(R.id.homefragment, fragInfo);
                            transaction.commit();*/
// for example get a value from the previous activity
                            /*Intent intent = getIntent();
                            out = intent.getExtras().getString("Key");*/


