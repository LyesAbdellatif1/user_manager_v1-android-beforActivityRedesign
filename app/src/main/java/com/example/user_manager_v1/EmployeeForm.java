package com.example.user_manager_v1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.user_manager_v1.model.Employee;
import com.example.user_manager_v1.reotrfit.EmployeeApi;
import com.example.user_manager_v1.reotrfit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeForm extends AppCompatActivity {
    Button buttonCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        FloatingActionButton floatingActionButton = findViewById(R.id.goTOHistoriqye);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmployeeListActivity.class);
                startActivity(intent);
            }
        });


        initializeComponents();
        buttonCall = findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                TextInputEditText inputEditLocation = findViewById(R.id.form_textFieldLocation);
                String location = String.valueOf(inputEditLocation.getText());
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + location));
                startActivity(intent);

            }
        });
    }

    private void initializeComponents() {
        TextInputEditText inputEditTextName = findViewById(R.id.form_textFieldName);
        TextInputEditText inputEditBranch = findViewById(R.id.form_textFieldBranch);
        TextInputEditText inputEditLocation = findViewById(R.id.form_textFieldLocation);
        Button buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);


        buttonSave.setOnClickListener(view -> {


            String name = String.valueOf(inputEditTextName.getText());
            String branch = String.valueOf(inputEditBranch.getText());
            String location = String.valueOf(inputEditLocation.getText());
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(location, null, branch, null, null);
                Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Some fields is Empty", Toast.LENGTH_LONG).show();
            }

            Employee employee = new Employee();
            employee.setName(name);
            employee.setBranch(branch);
            employee.setLocation(location);

            employeeApi.save(employee)
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Toast.makeText(EmployeeForm.this, "Save successful!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(EmployeeForm.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });


        });
    }
}