package com.example.timeline_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterUser extends AppCompatActivity {
    EditText registerUserName,registerName,registerPhone,registerEmail,registerAddress,registerPassword;
    Button regBtn;

    String username,fullName,phone,email,address,password;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        registerUserName = findViewById(R.id.activity_registerUser_username);
        registerName = findViewById(R.id.activity_registerUser_fullname);
        registerPhone = findViewById(R.id.activity_registerUser_phone);
        registerEmail = findViewById(R.id.activity_registerUser_email);
        registerAddress = findViewById(R.id.activity_registerUser_address);
        registerPassword = findViewById(R.id.activity_registerUser_password);
        regBtn = findViewById(R.id.activity_registerUser_r_btn);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formate1 =new SimpleDateFormat("dd-MM-yyyy");
        String day = formate1.format(calendar.getTime());

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = registerUserName.getText().toString();
                fullName = registerName.getText().toString();
                phone = registerPhone.getText().toString();
                email = registerEmail.getText().toString();
                address = registerAddress.getText().toString();
                password = registerPassword.getText().toString();

                Boolean regUser = dataBaseHelper.insertData(username,fullName,email,phone,address,password,day);
                if(regUser){
                    Toast.makeText(RegisterUser.this, "Registered "+ username, Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

}