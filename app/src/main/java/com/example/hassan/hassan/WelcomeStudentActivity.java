package com.example.hassan.hassan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HASSAN on 05/12/2017.
 */

public class WelcomeStudentActivity extends AppCompatActivity {
    RadioButton first,second;
    String selectedSubject="";
    TextView welcome_student;
    Button next;
    Spinner subject;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_student);

        first = (RadioButton)findViewById(R.id.first);
        second = (RadioButton)findViewById(R.id.second);
        welcome_student = (TextView)findViewById(R.id.welcom_std);
        welcome_student.setText("Wellcome "+getIntent().getStringExtra("Name"));
        next=(Button)findViewById(R.id.next);
        first.setChecked(true);
        subject = (Spinner)findViewById(R.id.subjcts);
        final ArrayList<String> Subjects=new ArrayList<>();
        final ArrayAdapter<String> SubjectAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,Subjects);
        subject.setAdapter(SubjectAdapter);
        subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 selectedSubject =Subjects.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first.isChecked()){
                    Subjects.clear();
                    Subjects.add("نظم زمن حقيقي");
                    Subjects.add("امن معلومات");
                    Subjects.add("تطبيقات شبكيه");
                    Subjects.add("تعليم الكتروني");
                    Subjects.add("نظم رقميخ");
                    SubjectAdapter.notifyDataSetChanged();
                }else {
                    Subjects.clear();
                    Subjects.add("مقرر 1 فصل تاني");
                    Subjects.add("مقرر 2 فصل تاني");
                    Subjects.add("مقرر 3 فصل تاني");
                    Subjects.add("مقرر 4 فصل تاني");
                    SubjectAdapter.notifyDataSetChanged();
                }
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first.isChecked()){
                    Subjects.clear();
                    Subjects.add("نظم زمن حقيقي");
                    Subjects.add("امن معلومات");
                    Subjects.add("تطبيقات شبكيه");
                    Subjects.add("تعليم الكتروني");
                    Subjects.add("نظم رقميخ");
                    SubjectAdapter.notifyDataSetChanged();
                }else {
                    Subjects.clear();
                    Subjects.add("مقرر 1 فصل تاني");
                    Subjects.add("مقرر 2 فصل تاني");
                    Subjects.add("مقرر 3 فصل تاني");
                    Subjects.add("مقرر 4 فصل تاني");
                    SubjectAdapter.notifyDataSetChanged();
                }
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first.isChecked()){
                    Subjects.clear();
                    Subjects.add("نظم زمن حقيقي");
                    Subjects.add("امن معلومات");
                    Subjects.add("تطبيقات شبكيه");
                    Subjects.add("تعليم الكتروني");
                    Subjects.add("نظم رقميخ");
                    SubjectAdapter.notifyDataSetChanged();
                }else {
                    Subjects.clear();
                    Subjects.add("مقرر 1 فصل تاني");
                    Subjects.add("مقرر 2 فصل تاني");
                    Subjects.add("مقرر 3 فصل تاني");
                    Subjects.add("مقرر 4 فصل تاني");
                    SubjectAdapter.notifyDataSetChanged();
                }
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first.isChecked()){
                    Subjects.clear();
                    Subjects.add("نظم زمن حقيقي");
                    Subjects.add("امن معلومات");
                    Subjects.add("تطبيقات شبكيه");
                    Subjects.add("تعليم الكتروني");
                    Subjects.add("نظم رقميخ");
                    SubjectAdapter.notifyDataSetChanged();
                }else {
                    Subjects.clear();
                    Subjects.add("مقرر 1 فصل تاني");
                    Subjects.add("مقرر 2 فصل تاني");
                    Subjects.add("مقرر 3 فصل تاني");
                    Subjects.add("مقرر 4 فصل تاني");
                    SubjectAdapter.notifyDataSetChanged();
                }
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first.isChecked()){
                    Subjects.clear();
                    Subjects.add("نظم زمن حقيقي");
                    Subjects.add("امن معلومات");
                    Subjects.add("تطبيقات شبكيه");
                    Subjects.add("تعليم الكتروني");
                    Subjects.add("نظم رقميخ");
                    SubjectAdapter.notifyDataSetChanged();
                }else {
                    Subjects.clear();
                    Subjects.add("مقرر 1 فصل تاني");
                    Subjects.add("مقرر 2 فصل تاني");
                    Subjects.add("مقرر 3 فصل تاني");
                    Subjects.add("مقرر 4 فصل تاني");
                    SubjectAdapter.notifyDataSetChanged();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tearm = 3;
                if (first.isChecked()){
                    tearm = 1;
                }else if (second.isChecked()){
                    tearm = 2;
                }else {
                    Toast.makeText(getApplicationContext(),"please select Tearm",Toast.LENGTH_SHORT).show();
                }
                if (!selectedSubject.isEmpty()&& tearm !=3){
                    Intent intent = new Intent(WelcomeStudentActivity.this,AnswerQuestionActivity.class);
                    intent.putExtra("Subject",selectedSubject);
                    intent.putExtra("Name",getIntent().getStringExtra("Name"));
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"please select Subject and Tearm",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
