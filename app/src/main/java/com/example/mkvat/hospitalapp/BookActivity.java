package com.example.mkvat.hospitalapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class  BookActivity extends AppCompatActivity {

     String doctor;
     String category;
     String centre1;
     String centre2;

     int i1,i2;
    int count;

     TextView doctorName;
     TextView doctorCategory;
     TextView dateSlot1;
     TextView timeSlot1;
     TextView dateSlot2;
     TextView timeSlot2;
     TextView patientCount1;
     TextView patientCount2;

     int b1,b2;

     public final static String key1="key1";
     public final static String key2="key2";
     public final static String key3="key3";
     public final static String key4="key4";
    public final static String key5="key5";
    public final static String key6="key6";
    public final static String key7="key7";
    public final static String date1="date1";
    public final static String time1="time1";
    public final static String date2="date2";
    public final static String time2="time2";
    public final static String patCount="pcount";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointmentlist);

        final Button book1= findViewById(R.id.book1);
        Button book2= findViewById(R.id.book2);

        doctorName=findViewById(R.id.doctorName);
        doctorCategory=findViewById(R.id.docCategory);

        dateSlot1=findViewById(R.id.dateslot1);
        timeSlot1=findViewById(R.id.timeslot1);
        patientCount1=findViewById(R.id.count1);

        dateSlot2=findViewById(R.id.dateslot2);
        timeSlot2=findViewById(R.id.timeslot2);
        patientCount2=findViewById(R.id.count2);

        Intent intent=getIntent();
        doctor=intent.getStringExtra(DisplayDoctor.key1);
        category=intent.getStringExtra(DisplayDoctor.key2);
        i1=intent.getIntExtra(DisplayDoctor.key5,1);
        i2=intent.getIntExtra(DisplayDoctor.key6,2);

       if(count ==0)
       {
           count=0;
       }

        if (i1 == R.id.c1) {
            if (doctor.equals("Dr Harsha Samarajeewa")) {

                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 29 2018");
                timeSlot1.setText("Wednesday 04.00pm");

                dateSlot2.setText("September 1 2018");
                timeSlot2.setText("Saturday 08.00am");


            } else if (doctor.equals("Dr Rizan Badudeen")) {
                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 30 2018");
                timeSlot1.setText("Thursday 02.00pm");

                dateSlot2.setText("September 2 2018");
                timeSlot2.setText("Sunday 08.00am");

            } else if (doctor.equals("Dr Nimal JayaSinghe")) {
                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 31 2018");
                timeSlot1.setText("Friday 02.00pm");

                dateSlot2.setText("September 2 2018");
                timeSlot2.setText("Sunday 08.00am");

            } else if (doctor.equals("Dr Chandana Amarasinghe")) {
                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 28 2018");
                timeSlot1.setText("Tuesday 01.00pm");

                dateSlot2.setText("August 30 2018");
                timeSlot2.setText("Thursday 08.00am");

            }

        }

        else if (i2 == R.id.c2) {
            if (doctor.equals("Dr Harsha Samarajeewa")) {

                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 27 2018");
                timeSlot1.setText("Monday 09.00am");

                dateSlot2.setText("September 1 2018");
                timeSlot2.setText("Saturday 03.00pm");


            } else if (doctor.equals("Dr Rizan Badudeen")) {
                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 31 2018");
                timeSlot1.setText("Friday 03.00pm");

                dateSlot2.setText("September 3 2018");
                timeSlot2.setText("Monday 08.00am");

            } else if (doctor.equals("Dr Nimal JayaSinghe")) {
                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 31 2018");
                timeSlot1.setText("Friday 02.00pm");

                dateSlot2.setText("September 2 2018");
                timeSlot2.setText("Sunday 08.00am");

            } else if (doctor.equals("Dr Chandana Amarasinghe")) {
                doctorName.setText(doctor);
                doctorCategory.setText(category);

                dateSlot1.setText("August 28 2018");
                timeSlot1.setText("Tuesday 01.00pm");

                dateSlot2.setText("August 30 2018");
                timeSlot2.setText("Thursday 08.00am");

            }
        }


        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date=dateSlot1.getText().toString();
                String time=timeSlot1.getText().toString();
                count+=1;
                patientCount1.setText(String.valueOf(count));
                Intent i=new Intent(BookActivity.this,PatientDetails.class);
                i.putExtra(key1,doctor);
                i.putExtra(key7,category);
                i.putExtra(key5,i1);
                i.putExtra(key6,i2);
                startActivity(i);
            }
        });

        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date=dateSlot2.getText().toString();
                String time=timeSlot2.getText().toString();
                count+=1;
                patientCount2.setText(String.valueOf(count));
                Intent i=new Intent(BookActivity.this,PatientDetails.class);
                i.putExtra(key1,doctor);
                i.putExtra(key7,category);
                i.putExtra(key5,i1);
                i.putExtra(key6,i2);
                startActivity(i);
            }
        });





    }
}
