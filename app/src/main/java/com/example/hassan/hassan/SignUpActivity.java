package com.example.hassan.hassan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hassan on 12/2/17.
 */

public class SignUpActivity extends AppCompatActivity {
    TextView name,email,pass,pass2;
    RadioButton programing, network;

    Button back,submit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = (TextView)findViewById(R.id.r_name);
        email = (TextView)findViewById(R.id.r_email);
        pass = (TextView)findViewById(R.id.r_password);
        pass2 = (TextView)findViewById(R.id.r_re_password);
        programing =(RadioButton)findViewById(R.id.programing);
        network =(RadioButton)findViewById(R.id.network);
        back = (Button)findViewById(R.id.back);
        submit = (Button)findViewById(R.id.register);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                SignUpActivity.this.finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String nam = name.getText().toString().trim();
                String passs = pass.getText().toString().trim();
                String passs2 = pass2.getText().toString().trim();
                int major =5;
                if (programing.isChecked()){
                   major = 0;
                }else if (network.isChecked()){
                    major=1;
                }

                if (!mail.isEmpty()||!nam.isEmpty()||!passs.isEmpty()||!passs2.isEmpty()||major!=5){
                    if (passs.equals(passs2)) {

                        UserDBHelper userDBHelper = new UserDBHelper(getApplicationContext());
                        userDBHelper.addUser(nam, mail, passs, major);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("Name", nam);
                        startActivity(intent);
                    }else Toast.makeText(getApplicationContext(),"password not match",Toast.LENGTH_SHORT).show();
                }else Toast.makeText(getApplicationContext(),"you have to fill all the field",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
