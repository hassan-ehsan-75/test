package com.example.hassan.hassan;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by HASSAN on 05/12/2017.
 */

public class AnswerQuestionActivity extends AppCompatActivity {
    TextView subject;
    CheckBox ans1,ans2;
    Button check;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_question);
        subject = (TextView)findViewById(R.id.selcted_sbjct);
        ans1 = (CheckBox)findViewById(R.id.answer1);
        ans2 = (CheckBox)findViewById(R.id.answer2);
        check = (Button) findViewById(R.id.check_answer);
        subject.setText(getIntent().getStringExtra("Subject"));
        if (subject.getText().equals("نظم زمن حقيقي")){
            ans1.setText("android fragment is compenent which acn live in activity");
            ans2.setText("android Acitvity is compenent which acn live in fragment");
        }
        final long time = new Date().getTime();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDBHelper userDBHelper = new UserDBHelper(getApplicationContext());
                if (ans1.isChecked()&&!ans2.isChecked()){
                    if ((time-new Date().getTime())<120000) {

                        userDBHelper.UpdateUser(getIntent().getStringExtra("Name"),1);
                        Toast.makeText(getApplicationContext(), "Right  answer you are acepted", Toast.LENGTH_SHORT).show();
                    }else {
                        userDBHelper.UpdateUser(getIntent().getStringExtra("Name"),0);
                        Toast.makeText(getApplicationContext(),"Time Out you are Not acepted",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    userDBHelper.UpdateUser(getIntent().getStringExtra("Name"),0);
                    Toast.makeText(getApplicationContext(),"Wrong  answer you are Not acepted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
