package com.example.mkvat.hospitalapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientDetails extends AppCompatActivity {

    int i1,i2;
    String doctor,category;
    Button c;

    EditText editText1,editText2,editText3,editText4;
     String name,contactNo,email,NIC;


    public final static String name1="k1";
    public final static String key2="k2";
    public final static String key3="ke";
    public final static String key4="k4";
    public final static String doc1="k5";
    public final static String doc2="k6";
    public final static String b1="k7";
    public final static String b2="k8";
    public final static String n1="k9";
    public final static String k2="k10";
    public final static String k3="k11";
    public final static String k4="k12";
    public final static String cat1="k13";
    public final static String cat2="k14";
    public final static String c1="c1";
    public final static String c2="c2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientdetails);

        c=findViewById(R.id.c);

        Intent i=getIntent();
        i1=i.getIntExtra(BookActivity.key5,1) ;
        i2=i.getIntExtra(BookActivity.key6,2) ;

        doctor=i.getStringExtra(BookActivity.key1);
        category=i.getStringExtra(BookActivity.key7);


        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);



       c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name=editText1.getText().toString();
                contactNo=editText2.getText().toString();
                email=editText3.getText().toString();
                NIC=editText4.getText().toString();
                if(i1 == R.id.c1)
                {


                   Intent it=new Intent(PatientDetails.this,GenerateDrReceipt.class);
                    it.putExtra(doc1,doctor);
                    it.putExtra(cat1,category);
                    it.putExtra(name1,name);
                    it.putExtra(key2,contactNo);
                    it.putExtra(key3,email);
                    it.putExtra(key4,NIC);
                    it.putExtra(b1,i1);
                    startActivity(it);
                }
                if(i2 == R.id.c2)
                {

                    Intent it=new Intent(PatientDetails.this,GenerateDrReceipt.class);
                    it.putExtra(doc2,doctor);
                    it.putExtra(cat2,category);
                    it.putExtra(n1,name);
                    it.putExtra(k2,contactNo);
                    it.putExtra(k3,email);
                    it.putExtra(k4,NIC);
                    it.putExtra(b2,i2);
                    startActivity(it);
                }
            }
        });

    }
}