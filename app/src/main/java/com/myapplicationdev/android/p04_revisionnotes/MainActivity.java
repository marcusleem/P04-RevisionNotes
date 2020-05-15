package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShowLV;
    RadioGroup rg;
    EditText etContent;
    SQLiteDatabase db;
    DBHelper dbContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShowLV = findViewById(R.id.buttonShowList);
        etContent = findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);

        btnShowLV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);
                String content = etContent.getText().toString();
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selected);
                int stars = Integer.parseInt(rb.getText().toString());
                // Insert a task
                db = new DBHelper(MainActivity.this);
                db.insertNote(content, stars);
                db.close();
                Toast.makeText(MainActivity.this,"Added", Toast.LENGTH_LONG).show();
            }
        });

    }


}