package com.example.sqliteassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqliteassignment.R;
import com.example.sqliteassignment.database.DBHelper;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        db = new DBHelper(this);
        db.getReadableDatabase();
    }

    private void initView() {
    }
}