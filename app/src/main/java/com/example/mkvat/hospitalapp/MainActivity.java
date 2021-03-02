package com.example.mkvat.hospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;//find doctor
    Button b2;//doctoro appointment
    Button b3;//Medical Records
    Button b4;//payment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SQLiteHelper ddb=new SQLiteHelper(MainActivity.this);

        ddb.addDoctor(new Doctor("D01","Dr Harsha Samarajeewa","Physician","Asiri Medical","Asiri Central",1200));
        ddb.addDoctor(new Doctor("D02","Dr Rizan Badudeen","Gastroentrologist","Asiri Central","Asiri Surgical",1500));
        ddb.addDoctor(new Doctor("D03","Dr Nimal JayaSinghe","Physician","Asiri Medical","Asiri Central",1400));
        ddb.addDoctor(new Doctor("D04","Dr Chandana Amarasinghe","Physician","Asiri Medical","Asiri Central",1200));


        ddb.addReport(new Report("R01","Cholestrol",2000));
        ddb.addReport(new Report("R02","Full Blood Count",1500));
        ddb.addReport(new Report("R03","Liver Test",4000));
        ddb.addReport(new Report("R04","C protein test",2500));


        ddb.addDetails(new HospitalCost("H01","Asiri Medical",700,800));
        ddb.addDetails(new HospitalCost("H02","Asiri Central",800,850));
        ddb.addDetails(new HospitalCost("H03","Asiri Surigcal",900,920));

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,FinddoctorActivity.class);
                startActivity(i);
            }
        });

        b2=(Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,LabAppointmentActivity.class);
                startActivity(i);
            }
        });
        b3=(Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,CalculateBMI.class);
                startActivity(i);
            }
        });
        b4=(Button)findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,PaymentActivity.class);
                startActivity(i);
            }
        });

    }
}
