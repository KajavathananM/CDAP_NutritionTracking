package com.example.mkvat.hospitalapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GenerateDrReceipt extends AppCompatActivity {

    TextView doc,cat,t1,t2,t3,t4,t5,t6,t7,t8,t9,total,h;
    Button cancel,home;
    String name,contactNo,email,NIC;
    String doctor,category;
    int i1,i2;
    double dcharge,bcharge,hcharge;
    double t;
    String total_;
    String centre1,centre2;
    String room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drreciept);

        doc=findViewById(R.id.doc);
        cat=findViewById(R.id.cat);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);
        total=findViewById(R.id.t10);

        h=findViewById(R.id.h);

        cancel=findViewById(R.id.ca1);
        home=findViewById(R.id.home1);

        Intent it=getIntent();
        i1=it.getIntExtra(PatientDetails.b1,1);
        i2=it.getIntExtra(PatientDetails.b2,2);








        if(i1 == R.id.c1)
        {
            doctor=it.getStringExtra(PatientDetails.doc1);
            category=it.getStringExtra(PatientDetails.cat1);
            name= it.getStringExtra(PatientDetails.name1);
            contactNo=it.getStringExtra(PatientDetails.key2);
            email=it.getStringExtra(PatientDetails.key3);
            NIC=it.getStringExtra(PatientDetails.key4);
            doc.setText(doctor);
            cat.setText(category);
            t2.setText(name);
            t3.setText(contactNo);
            t4.setText(email);
            t5.setText(NIC);
            if(doctor.equals("Dr Harsha Samarajeewa"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre1=s.getDoctor("Dr Harsha Samarajeewa").getCentre1();
                h.setText(centre1);
                room="2nd floor C11";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre1).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Harsha Samarajeewa").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre1).getBookingCharge()));
            }
            else if(doctor.equals("Dr Rizan Badudeen"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre1=s.getDoctor("Dr Rizan Badudeen").getCentre1();
                h.setText(centre1);
                room="3rd floor 307";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre1).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Rizan Badudeen").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre1).getBookingCharge()));
            }
            else if(doctor.equals("Dr Nimal JayaSinghe"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre1=s.getDoctor("Dr Nimal JayaSinghe").getCentre1();
                h.setText(centre1);
                room="2nd floor C6";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre1).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Nimal JayaSinghe").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre1).getBookingCharge()));

            }
            else if(doctor.equals("Dr Chandana Amarasinghe"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre1=s.getDoctor("Dr Chandana Amarasinghe").getCentre1();
                h.setText(centre1);
                room="2nd floor C10";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre1).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Chandana Amarasinghe").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre1).getBookingCharge()));
            }
            hcharge=Double.parseDouble(t7.getText().toString());
            dcharge=Double.parseDouble(t8.getText().toString());
            bcharge=Double.parseDouble(t9.getText().toString());
            t=dcharge+bcharge+hcharge;
            total_= String.valueOf(t);
            total.setText(total_);

            SQLiteHelper db=new SQLiteHelper(GenerateDrReceipt.this);
            db.createDrBill(new DrReceiptData(name,contactNo,email,NIC,doctor,centre1,room,bcharge,hcharge,dcharge,t));
            t1.setText("RE"+String.valueOf(db.getDrReceipt(name).getRefid()));

        }

        if(i2 == R.id.c2)
        {
            doctor=it.getStringExtra(PatientDetails.doc2);
            category=it.getStringExtra(PatientDetails.cat2);
            name= it.getStringExtra(PatientDetails.n1);
            contactNo=it.getStringExtra(PatientDetails.k2);
            email=it.getStringExtra(PatientDetails.k3);
            NIC=it.getStringExtra(PatientDetails.k4);
            doc.setText(doctor);
            cat.setText(category);
            t2.setText(name);
            t3.setText(contactNo);
            t4.setText(email);
            t5.setText(NIC);
            if(doctor.equals("Dr Harsha Samarajeewa"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre2=s.getDoctor("Dr Harsha Samarajeewa").getCentre2();
                h.setText(centre2);
                room="4th floor A402";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre2).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Harsha Samarajeewa").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre2).getBookingCharge()));
            }
            else if(doctor.equals("Dr Rizan Badudeen"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre2=s.getDoctor("Dr Rizan Badudeen").getCentre2();
                h.setText(centre2);
                room="5th floor A503";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre2).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Rizan Badudeen").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre2).getBookingCharge()));

            }
            else if(doctor.equals("Dr Nimal JayaSinghe"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre2=s.getDoctor("Dr Nimal JayaSinghe").getCentre2();
                h.setText(centre2);
                room="4th floor 406";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre2).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Nimal JayaSinghe").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre2).getBookingCharge()));
            }
            else if(doctor.equals("Dr Chandana Amarasinghe"))
            {
                SQLiteHelper s=new SQLiteHelper(GenerateDrReceipt.this);
                centre2=s.getDoctor("Dr Chandana Amarasinghe").getCentre2();
                h.setText(centre2);
                room="4th floor 410";
                t6.setText(room);
                t7.setText(String.valueOf(s.getCostDetails(centre2).getHospCharge()));
                t8.setText(String.valueOf(s.getDoctor("Dr Chandana Amarasinghe").getDocCharge()));
                t9.setText(String.valueOf(s.getCostDetails(centre2).getBookingCharge()));
            }
            hcharge=Double.parseDouble(t7.getText().toString());
            dcharge=Double.parseDouble(t8.getText().toString());
            bcharge=Double.parseDouble(t9.getText().toString());
            t=dcharge+bcharge+hcharge;
            total_= String.valueOf(t);
            total.setText(total_);

            SQLiteHelper db=new SQLiteHelper(GenerateDrReceipt.this);
            db.createDrBill(new DrReceiptData(name,contactNo,email,NIC,doctor,centre2,room,bcharge,hcharge,dcharge,t));
            t1.setText("DRE"+String.valueOf(db.getDrReceipt(name).getRefid()));

        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(GenerateDrReceipt.this,MainActivity.class);
                startActivity(i);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper db=new SQLiteHelper(GenerateDrReceipt.this);
                db.deleteDrBill(db.getDrReceipt( name));
                Toast.makeText(GenerateDrReceipt.this, "Cancel Dr Appointment", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(GenerateDrReceipt.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}


