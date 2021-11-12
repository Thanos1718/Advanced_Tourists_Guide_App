package com.example.advancedtouristsguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.advancedtouristsguide.CheckCredentials.Validations;
import com.google.android.material.datepicker.MaterialTextInputPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button register= findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name_edit = findViewById(R.id.name_edittext);
                EditText userName_edit= findViewById(R.id.user_name_edittext);
                EditText email_edit=findViewById(R.id.email_edittext);
                EditText password_edit=findViewById(R.id.password_edittext);
                EditText cpassword_edit=findViewById(R.id.confirm_password_edittext);

                String name = name_edit.getText().toString();
                String userName= userName_edit.getText().toString();
                String email=email_edit.getText().toString();
                String password=password_edit.getText().toString();
                String cpassword=cpassword_edit.getText().toString();

                Validations validations=new Validations();
                boolean isName=validations.checkName(name);
                boolean isUserName=validations.checkUserName(userName);
                boolean isPassword=validations.checkPassword(password);
                boolean isConfirmPassword=validations.confirmPassword(cpassword,password);
                boolean isEmail=validations.checkEmail(email);
                if(!isEmail) {
                    email_edit.setError("Invalid email");
                    //Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG).show();
                }
                if(!isUserName)
                {
                  userName_edit.setError("User name is too short or exists");
                }
                if(!isName)
                {
                    name_edit.setError("Name is too short");
                }
                if(!isPassword)
                {
                   password_edit.setError("Password must be atleast 6 characters long");
                }
                if(!isConfirmPassword)
                {
                    cpassword_edit.setError("Password not match");
                }
            }
        });

    }
}