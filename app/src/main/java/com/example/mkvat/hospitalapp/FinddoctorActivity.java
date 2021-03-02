package com.example.mkvat.hospitalapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FinddoctorActivity extends AppCompatActivity {

    Spinner spDoctor;
    Spinner spCat;

    String docType[]={"Dr Harsha Samarajeewa","Dr Rizan Badudeen","Dr Nimal JayaSinghe","Dr Chandana Amarasinghe"};
    String catType[]={"Physician","Neurologist","Cardiologist","Paediatrician","Chest Specialist"};

    ArrayAdapter<String> adapterdocType;
    ArrayAdapter<String> adaptercatType;

    String doctor;

    Button search;

    public final static String key="key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finddoctor);

        search=findViewById(R.id.button);

        spDoctor=findViewById(R.id.spinner1);
        adapterdocType=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,docType);
        adapterdocType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDoctor.setAdapter(adapterdocType);

        spCat=findViewById(R.id.spinner2);
        adaptercatType=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,catType);
        adaptercatType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCat.setAdapter(adaptercatType);


        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                doctor=spDoctor.getSelectedItem().toString();
                if (doctor.equals("Dr Harsha Samarajeewa"))
                {
                    Intent i=new Intent(FinddoctorActivity.this,DisplayDoctor.class);
                    i.putExtra(key,doctor);
                    startActivity(i);
                }
                else if(doctor.equals("Dr Rizan Badudeen"))
                {
                    Intent i=new Intent(FinddoctorActivity.this,DisplayDoctor.class);
                    i.putExtra(key,doctor);
                    startActivity(i);
                }

                else if(doctor.equals("Dr Nimal JayaSinghe"))
                {
                    Intent i=new Intent(FinddoctorActivity.this,DisplayDoctor.class);
                    i.putExtra(key,doctor);
                    startActivity(i);
                }
                else if(doctor.equals("Dr Chandana Amarasinghe"))
                {
                    Intent i=new Intent(FinddoctorActivity.this,DisplayDoctor.class);
                    i.putExtra(key,doctor);
                    startActivity(i);
                }

            }
        });


    }
}


