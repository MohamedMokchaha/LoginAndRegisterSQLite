package com.example.loginandregistersqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText loginemail , loginpassword ;
    private Button login ,register ;
    DatabaseHelper db ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginemail=findViewById(R.id.loginemail);
        loginpassword=findViewById(R.id.loginpass) ;
        login=findViewById(R.id.login) ;
        db=new DatabaseHelper(this);

        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = loginemail.getText().toString();
                String Password = loginpassword.getText().toString();

                boolean checkEmailAndPassword=db.checkEmailAndPassword(Email,Password) ;
                if (Email.equals("") || Password.equals("")) {
                    Toast.makeText(getApplicationContext(), "field are empty", Toast.LENGTH_SHORT).show();

                } else {
                    if (checkEmailAndPassword) {

                        Toast.makeText(getApplicationContext(), "Email ou password est incorrect", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(getApplicationContext(), "Login avec succées", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }) ;

    }
}