package com.example.hassan.hassan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HASSAN on 05/12/2017.
 */

public class WellcomManagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom_manager);
        ListView userList = (ListView)findViewById(R.id.accepted_student);
        ArrayList<String> users  = new ArrayList<>();
        UserDBHelper userDBHelper = new UserDBHelper(getApplicationContext());
        users.addAll(userDBHelper.getUsers());
        ArrayAdapter<String> userAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,users);
        userList.setAdapter(userAdapter);

        userAdapter.notifyDataSetChanged();

    }
}
