package com.example.myapplication.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.controller.LoginController;

public class HomeActivity extends AppCompatActivity {

    private Button btnConsultation;
    private EditText etUserName;
    private EditText etPassword;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean usernamev=false;
                boolean passwordv=false;
                String username;
                String password;
                if(etUserName.getText().toString().isEmpty()){
                    Toast.makeText(HomeActivity.this,"le name est invalide",Toast.LENGTH_SHORT).show();
                }
                else {
                    usernamev=true;
                }
                if(etPassword.getText().toString().isEmpty()){
                    Toast.makeText(HomeActivity.this,"le password est invalide",Toast.LENGTH_SHORT).show();
                }
                else {
                    passwordv=true;
                }
                if(usernamev && passwordv){
                    username=etUserName.getText().toString();
                    password=etPassword.getText().toString();
                    loginController.createUser(username,password,HomeActivity.this);
                    Intent intent =new Intent(HomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    void init (){
        loginController=LoginController.getInstance(HomeActivity.this);
        btnConsultation=findViewById(R.id.btnConsultation);
        etPassword=findViewById(R.id.etPassword);
        etUserName=findViewById(R.id.etUserName);

    }
}