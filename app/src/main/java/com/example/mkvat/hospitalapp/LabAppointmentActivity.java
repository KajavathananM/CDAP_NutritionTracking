package com.example.mkvat.hospitalapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class LabAppointmentActivity extends AppCompatActivity {

    Spinner spBranch;
    Spinner spReport;

    String branchType[]={"Asiri Medical","Asiri Surgical","Asiri Central"};
    String reportType[]={"Cholestrol","Full Blood Count","Liver Test","C protein test"};

    ArrayAdapter<String> adapterBranchType;
    ArrayAdapter<String> adapterReportType;

    Button co;

    EditText et1,et2,et3,et4;
    String name,contacNo,email,NIC,rType,bhType;

    int id,ref;
    String n;

    public final static String ke1="name";//for name
    public final static String ke2="contactNo";//for contact No
    public final static String ke3="email";//for email
    public final static String ke4="NIC";//for Nic
    public final static String ke5="reportType";//for reportType
    public final static String ke6="branchType";//for branchType
    public final static String keyId="kei";
    public final static String keyRef="ker";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labappointment);

        spReport=(Spinner)findViewById(R.id.sp1);//report type
        spBranch=(Spinner)findViewById(R.id.sp2);//branch type
        et1=findViewById(R.id.et1);//name
        et2=findViewById(R.id.et2);//contact no
        et3=findViewById(R.id.et3);//email
        et4=findViewById(R.id.et4);//NIC
        co=findViewById(R.id.co);//button nexr



        adapterBranchType=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,branchType);
        adapterBranchType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBranch.setAdapter(adapterBranchType);

        adapterReportType=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,reportType);
        adapterReportType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spReport.setAdapter(adapterReportType);

        Intent it=getIntent();
        id=it.getIntExtra(GenerateLabReceipt.keyId,1);
        n=it.getStringExtra(GenerateLabReceipt.keyName);
        ref= it.getIntExtra(GenerateLabReceipt.keyRef,1);

        if(id == R.id.ua2)
        {
            SQLiteHelper db=new SQLiteHelper(LabAppointmentActivity.this);
            et1.setText(db.getLabReceipt(n).getPatientName());
            et2.setText(db.getLabReceipt(n).getContactNo());
            et3.setText(db.getLabReceipt(n).getEmail());
            et4.setText(db.getLabReceipt(n).getNic());

            String value1=db.getLabReceipt(n).getHospital();
            for (int index=0;index<spBranch.getCount();index++){
                if (spBranch.getItemAtPosition(index).toString().equalsIgnoreCase(value1)){
                    spBranch.setSelection(index);
                }
            }
            String value2=db.getLabReceipt(n).getReportType();
            for (int index=0;index<spReport.getCount();index++){
                if (spReport.getItemAtPosition(index).toString().equalsIgnoreCase(value2)){
                    spReport.setSelection(index);
                }
            }


        }



        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=et1.getText().toString();
                contacNo=et2.getText().toString();
                email=et3.getText().toString();
                NIC=et4.getText().toString();
                rType=spReport.getSelectedItem().toString();
                bhType=spBranch.getSelectedItem().toString();
                Intent i=new Intent(LabAppointmentActivity.this,CalenderControl.class);
                i.putExtra(ke1,name);
                i.putExtra(ke2,contacNo);
                i.putExtra(ke3,email);
                i.putExtra(ke4,NIC);
                i.putExtra(ke5,rType);
                i.putExtra(ke6,bhType);
                i.putExtra(keyId,id);
                i.putExtra(keyRef,ref);
                startActivity(i);



            }
        });

    }
}
