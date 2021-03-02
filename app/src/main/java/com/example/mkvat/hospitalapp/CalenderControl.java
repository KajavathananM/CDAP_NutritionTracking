package com.example.mkvat.hospitalapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class CalenderControl extends AppCompatActivity {

    DatePicker datePicker;
    Button next;

    int id;
    String ref;

    public final static String key="k1";


    String name,contactNo,email,NIC,rType,bhType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dateview);



        // initiate the date picker and a button
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        next = (Button) findViewById(R.id.next);



        Intent i=getIntent();
        name=i.getStringExtra(LabAppointmentActivity.ke1);
        contactNo=i.getStringExtra(LabAppointmentActivity.ke2);
        email=i.getStringExtra(LabAppointmentActivity.ke3);
        NIC=i.getStringExtra(LabAppointmentActivity.ke4);
        rType=i.getStringExtra(LabAppointmentActivity.ke5);
        bhType=i.getStringExtra(LabAppointmentActivity.ke6);


        id=i.getIntExtra(LabAppointmentActivity.keyId,1);
        ref=i.getStringExtra(LabAppointmentActivity.keyRef);


        // perform click event on next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the values for day of month , month and year from a date picker
                String day = String.valueOf(datePicker.getDayOfMonth());
                String month = String.valueOf((datePicker.getMonth() + 1));
                String year = String.valueOf(datePicker.getYear());
                String apDate=(day+"/"+month+"/"+year);

                if(id == R.id.ua2)
                {
                    Intent it=new Intent(CalenderControl.this,UpdateLabReceipt.class);
                    it.putExtra(key,apDate);
                    it.putExtra(LabAppointmentActivity.ke1,name);
                    it.putExtra(LabAppointmentActivity.ke2,contactNo);
                    it.putExtra(LabAppointmentActivity.ke3,email);
                    it.putExtra(LabAppointmentActivity.ke4,NIC);
                    it.putExtra(LabAppointmentActivity.ke5,rType);
                    it.putExtra(LabAppointmentActivity.ke6,bhType);
                    it.putExtra(LabAppointmentActivity.keyRef,ref);

                    startActivity(it);
                }
                else
               {

                   Intent i=new Intent(CalenderControl.this,GenerateLabReceipt.class);
                   i.putExtra(key,apDate);
                   i.putExtra(LabAppointmentActivity.ke1,name);
                   i.putExtra(LabAppointmentActivity.ke2,contactNo);
                   i.putExtra(LabAppointmentActivity.ke3,email);
                   i.putExtra(LabAppointmentActivity.ke4,NIC);
                   i.putExtra(LabAppointmentActivity.ke5,rType);
                   i.putExtra(LabAppointmentActivity.ke6,bhType);

                   startActivity(i);
               }
            }
        });

    }


}