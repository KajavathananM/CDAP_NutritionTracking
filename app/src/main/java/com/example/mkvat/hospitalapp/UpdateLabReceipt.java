package com.example.mkvat.hospitalapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateLabReceipt extends AppCompatActivity {

    TextView date,name,contactNumber,email,NIC,rType,rCharge,bhType,refNo;
    Button cancel,update,home;
    String v1;//for date
    String v2;//for name
    String v3;//for contactNo
    String v4;//for email
    String v5;//for NIC
    String v6;//for reportType
    String v7;//for branchType
    String v8;//for report Charge

    int id;
    int ref;

    public final static String keyId="bId";
    public final static String keyName="namee";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labreceipt);

        refNo=findViewById(R.id.refNo);
        date=findViewById(R.id.date);
        name=findViewById(R.id.name);
        contactNumber=findViewById(R.id.contact);
        email=findViewById(R.id.email);
        NIC=findViewById(R.id.nic);
        rType=findViewById(R.id.report);
        rCharge=findViewById(R.id.charge);
        bhType=findViewById(R.id.hospital);

        cancel=findViewById(R.id.ca2);
        update=findViewById(R.id.ua2);
        home=findViewById(R.id.home2);

        Intent i=getIntent();

        v1=i.getStringExtra(CalenderControl.key);
        v2=i.getStringExtra(LabAppointmentActivity.ke1);
        v3=i.getStringExtra(LabAppointmentActivity.ke2);
        v4=i.getStringExtra(LabAppointmentActivity.ke3);
        v5=i.getStringExtra(LabAppointmentActivity.ke4);
        v6=i.getStringExtra(LabAppointmentActivity.ke5);
        v7=i.getStringExtra(LabAppointmentActivity.ke6);
        date.setText(v1);
        name.setText(v2);
        contactNumber.setText(v3);
        email.setText(v4);
        NIC.setText(v5);
        rType.setText(v6);
        bhType.setText(v7);

        ref=i.getIntExtra(GenerateLabReceipt.keyRef,1);


           SQLiteHelper ldb=new SQLiteHelper(UpdateLabReceipt.this);
           if(v6.equals("Cholestrol"))
           {
               Report report=ldb.getReport("Cholestrol");
               v8= String.valueOf(report.getrCharge());
               rCharge.setText(v8);
           }
           else if(v6.equals("Full Blood Count"))
           {
               Report report=ldb.getReport("Full Blood Count");
               v8= String.valueOf(report.getrCharge());
               rCharge.setText(v8);
           }
           else if(v6.equals("Liver Test"))
           {
               Report report=ldb.getReport("Liver Test");
               v8= String.valueOf(report.getrCharge());
               rCharge.setText(v8);
           }
           else if(v6.equals("C protein test"))
           {
               Report report=ldb.getReport("C protein test");
               v8= String.valueOf(report.getrCharge());
               rCharge.setText(v8);
           }

           LabReceiptData l=ldb.getLabReceiptById(String.valueOf(ref));
           l.setPatientName(v2);
           l.setContactNo(v3);
           l.setEmail(v4);
           l.setNic(v5);
           l.setDate(v1);
           l.setReportType(v6);
           l.setReportCharge(Double.parseDouble(v8));
           l.setHospital(v7);
           ldb.updateLabBill(l);
           refNo.setText("LRE"+String.valueOf(ldb.getLabReceipt(v2).getRefid()));





        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UpdateLabReceipt.this,MainActivity.class);
                startActivity(i);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper db=new SQLiteHelper(UpdateLabReceipt.this);
                db.deleteLabBill(db.getLabReceipt(v2));
                Toast.makeText(UpdateLabReceipt.this, "Cancel Lab Appointment", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(UpdateLabReceipt.this,MainActivity.class);
                startActivity(i);
            }
        });

        id=update.getId();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UpdateLabReceipt.this,LabAppointmentActivity.class);
                i.putExtra(keyId,id);
                i.putExtra(keyName,v2);
                startActivity(i);
            }
        });


    }
}