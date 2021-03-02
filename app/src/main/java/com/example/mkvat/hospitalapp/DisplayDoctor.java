package com.example.mkvat.hospitalapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DisplayDoctor extends AppCompatActivity {
    Button channel1;
    Button channel2;

    public static final String key1 = "key1";
    public static final String key2 = "ke2";
    public static final String key3 = "key3";
    public static final String key4 = "key4";
    public static final String key5="key5";
    public static final String key6="key6";
    public static final String k6="k6";
    public String doctor;
    public int i1;
    public int i2;
    public String category;
    public String centre1;
    public String centre2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorprofile);


        channel1 = findViewById(R.id.c1);
        channel2 = findViewById(R.id.c2);

        TextView docName1 = findViewById(R.id.docName1);
        TextView category1 = findViewById(R.id.category1);
        final TextView branch1 = findViewById(R.id.branch1);

        TextView docName2 = findViewById(R.id.docName2);
        TextView category2 = findViewById(R.id.category2);
        TextView branch2 = findViewById(R.id.branch2);

        Intent i = getIntent();
        doctor = i.getStringExtra(FinddoctorActivity.key);

        SQLiteHelper ddb=new SQLiteHelper(DisplayDoctor.this);


        if (doctor.equals("Dr Harsha Samarajeewa")) {
            Doctor doctor=ddb.getDoctor("Dr Harsha Samarajeewa");
            docName1.setText(doctor.getDocName());
            category1.setText(doctor.getType());
            branch1.setText(doctor.getCentre1());

            docName2.setText(doctor.getDocName());
            category2.setText(doctor.getType());
            branch2.setText(doctor.getCentre2());
        } else if (doctor.equals("Dr Rizan Badudeen")) {
            Doctor doctor=ddb.getDoctor("Dr Rizan Badudeen");
            docName1.setText(doctor.getDocName());
            category1.setText(doctor.getType());
            branch1.setText(doctor.getCentre1());

            docName2.setText(doctor.getDocName());
            category2.setText(doctor.getType());
            branch2.setText(doctor.getCentre2());
        } else if (doctor.equals("Dr Nimal JayaSinghe")) {
            Doctor doctor=ddb.getDoctor("Dr Nimal JayaSinghe");
            docName1.setText(doctor.getDocName());
            category1.setText(doctor.getType());
            branch1.setText(doctor.getCentre1());

            docName2.setText(doctor.getDocName());
            category2.setText(doctor.getType());
            branch2.setText(doctor.getCentre2());
        } else if (doctor.equals("Dr Chandana Amarasinghe")) {
            Doctor doctor=ddb.getDoctor("Dr Chandana Amarasinghe");
            docName1.setText(doctor.getDocName());
            category1.setText(doctor.getType());
            branch1.setText(doctor.getCentre1());

            docName2.setText(doctor.getDocName());
            category2.setText(doctor.getType());
            branch2.setText(doctor.getCentre2());
        }

        category=category1.getText().toString();
        centre1=branch1.getText().toString();
        centre2=branch2.getText().toString();


        i1=channel1.getId();
        i2=channel2.getId();



        channel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayDoctor.this, BookActivity.class);
                intent.putExtra(key1,doctor);
                intent.putExtra(key2,category);
                intent.putExtra(key5,i1);
                startActivity(intent);
            }
        });





        channel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DisplayDoctor.this, BookActivity.class);
                it.putExtra(key1,doctor);
                it.putExtra(key2,category);
                it.putExtra(key6,i2);

                startActivity(it);
            }
        });
    }


}