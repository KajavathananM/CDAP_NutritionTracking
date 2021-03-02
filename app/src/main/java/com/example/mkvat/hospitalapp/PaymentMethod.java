package com.example.mkvat.hospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentMethod extends AppCompatActivity {

    Button master,visa;
    int id1,id2;
    String name,paymentType,branch,refNo,amount;
    String pyName,pyContact,pyEmail,pyNIC;
    TextView merchant;

    public final static String keyID1="id1";
    public final static String keyID2="id2";

    public final static String keyName="n";
    public final static String keyBranch="b";
    public final static String keypayType="p";
    public final static String keyRefNo="r";
    public final static String keyAmount="amt";

    public final static String keyPyName="pyN";
    public final static String keyPyNIC="pyNI";
    public final static String keyPyEmail="pyEl";
    public final static String keyPycontact="pyC";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentmethod);

        merchant=findViewById(R.id.merchantName);
        visa=findViewById(R.id.visa);
        master=findViewById(R.id.master);


        id1=visa.getId();
        id2=master.getId();

        Intent it=getIntent();
        name=it.getStringExtra(PaymentActivity.keyName);
        branch=it.getStringExtra(PaymentActivity.keyBranch);
        paymentType=it.getStringExtra(PaymentActivity.keypayType);
        refNo=it.getStringExtra(PaymentActivity.keyRefNo);
        amount= it.getStringExtra(PaymentActivity.keyAmount);

        pyName=it.getStringExtra(PaymentActivity.keyPyName);
        pyNIC=it.getStringExtra(PaymentActivity.keyPyNIC);
        pyEmail=it.getStringExtra(PaymentActivity.keyPyEmail);
        pyContact=it.getStringExtra(PaymentActivity.keyPycontact);


        merchant.setText(branch);

       visa.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(PaymentMethod.this,EnterCardDetails.class);
               i.putExtra(keyID1,id1);
               i.putExtra(keyName,name);
               i.putExtra(keyBranch,branch);
               i.putExtra(keypayType,paymentType);
               i.putExtra(keyRefNo,refNo);
               i.putExtra(keyAmount,amount);

               i.putExtra(keyPyName,pyName);
               i.putExtra(keyPyNIC,pyNIC);
               i.putExtra(keyPyEmail,pyEmail);
               i.putExtra(keyPycontact,pyContact);


               startActivity(i);
           }
       });

       master.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(PaymentMethod.this,EnterCardDetails.class);
               i.putExtra(keyID2,id2);
               i.putExtra(keyName,name);
               i.putExtra(keyBranch,branch);
               i.putExtra(keypayType,paymentType);
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
