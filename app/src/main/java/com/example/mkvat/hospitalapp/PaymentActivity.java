package com.example.mkvat.hospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PaymentActivity extends AppCompatActivity {

    Spinner spBranchType;
    Spinner spPayType;


    String branchType[]={"Asiri Medical","Asiri Surgical","Asiri Central"};
    String payType[]={"Pharmacy Bill","Doctor receipt","Lab receipt","Room Bill"};

    ArrayAdapter<String> adapterBranchType;
    ArrayAdapter<String> adapterPayType;

    Button next;

    EditText e1,e2,e3,e4,e5,e6,e7;

    public final static String keyName="name";
    public final static String keyBranch="branch";
    public final static String keypayType="paymentType";
    public final static String keyRefNo="RefNo";
    public final static String keyAmount="amount";

    public final static String keyPyName="pyName";
    public final static String keyPyNIC="pyNIC";
    public final static String keyPyEmail="pyEmail";
    public final static String keyPycontact="pyContact";




    String name,paymentType,branch,refNo,amount;
    String pyName,pyContact,pyEmail,pyNIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        spBranchType = findViewById(R.id.spinner1);
        spPayType = findViewById(R.id.spinner2);


        adapterBranchType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, branchType);
        adapterBranchType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBranchType.setAdapter(adapterBranchType);


        adapterPayType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, payType);
        adapterPayType.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spPayType.setAdapter(adapterPayType);

        e1=findViewById(R.id.e1);//patient name
        e2=findViewById(R.id.e2);//reference no
        e3=findViewById(R.id.e3);//amount

        e4=findViewById(R.id.e4);//payer name
        e5=findViewById(R.id.e5);//payer nic or passport
        e6=findViewById(R.id.e6);//payer email
        e7=findViewById(R.id.e7);//payer contactNo

        next=findViewById(R.id.next);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(PaymentActivity.this, PaymentMethod.class);
                name=e1.getText().toString();
                branch=spBranchType.getSelectedItem().toString();
                paymentType=spPayType.getSelectedItem().toString();
                refNo=e2.getText().toString();
                amount=e3.getText().toString();

                pyName=e4.getText().toString();
                pyNIC=e5.getText().toString();
                pyEmail=e6.getText().toString();
                pyContact=e7.getText().toString();

                i.putExtra(keyName,name);
                i.putExtra(keypayType,paymentType);
                i.putExtra(keyBranch,branch);
                i.putExtra(keyRefNo,refNo);
                i.putExtra(keyAmount,amount);


                i.putExtra(keyPyName,pyName);
                i.putExtra(keyPyNIC,pyNIC);
                i.putExtra(keyPyEmail,pyEmail);
                i.putExtra(keyPycontact,pyContact);

                startActivity(i);
            }
        });




    }
}
