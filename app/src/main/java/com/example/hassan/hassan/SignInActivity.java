package com.example.hassan.hassan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hassan on 11/30/17.
 */

public class SignInActivity extends AppCompatActivity {
    EditText name,password;
    Button sing,rig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        sing = (Button)findViewById(R.id.singIn);
        rig= (Button)findViewById(R.id.rigist);
        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = name.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (email.length() != 0 && pass.length() != 0) {
                    UserDBHelper userDBHelper = new UserDBHelper(getApplicationContext());
                    if (!userDBHelper.isExist(email,pass).isEmpty()||userDBHelper.isExist(email,pass)!=null){
                        if (userDBHelper.getType(email)==0) {
                            Intent intent = new Intent(SignInActivity.this, WellcomManagerActivity.class);
                            intent.putExtra("Name", userDBHelper.isExist(email, pass));
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent(SignInActivity.this, WelcomeStudentActivity.class);
                            intent.putExtra("Name", userDBHelper.isExist(email, pass));
                            startActivity(intent);
                        }
                    }

                } else{
                    Toast.makeText(getApplicationContext(),"Wrong Name Or Password",Toast.LENGTH_SHORT).show();
                }


            }
        });

        rig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
            }
        });

    }
}