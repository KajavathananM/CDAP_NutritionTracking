package com.example.mkvat.hospitalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EnterCardDetails extends AppCompatActivity {

    int id1,id2;
    String name,paymentType,branch,refNo,amount;
    String pyName,pyContact,pyEmail,pyNIC;
    TextView cardName,amt,merchantName;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_details);


        cardName=findViewById(R.id.cardName);
        amt=findViewById(R.id.amt);
        merchantName=findViewById(R.id.m);
        pay=findViewById(R.id.pay);

        Intent i=getIntent();
        id1=i.getIntExtra(PaymentMethod.keyID1,1);
        id2=i.getIntExtra(PaymentMethod.keyID2,2);
        name=i.getStringExtra(PaymentMethod.keyName);
        branch=i.getStringExtra(PaymentMethod.keyBranch);
        paymentType=i.getStringExtra(PaymentMethod.keypayType);
        refNo=i.getStringExtra(PaymentMethod.keyRefNo);
        amount= i.getStringExtra(PaymentMethod.keyAmount);

        pyName=i.getStringExtra(PaymentMethod.keyPyName);
        pyNIC=i.getStringExtra(PaymentMethod.keyPyNIC);
        pyEmail=i.getStringExtra(PaymentMethod.keyPyEmail);
        pyContact=i.getStringExtra(PaymentMethod.keyPycontact);





        if(id1 == R.id.visa)
        {
            cardName.setText("Visa Card");
            merchantName.setText(branch);
            amt.setText(amount);
        }
        if(id2 == R.id.master)
        {
            cardName.setText("Master Card");
            merchantName.setText(branch);
            amt.setText(amount);
        }
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper ddb=new SQLiteHelper(EnterCardDetails.this);
                ddb.createPayment(new Payment(name,branch,paymentType,refNo,Double.parseDouble(amount)));
                ddb.addPayer(new Payer( pyName,pyContact, pyEmail, pyNIC));

                LayoutInflater inflater = getLayoutInflater();
                View toastLayout = inflater.inflate(R.layout.content_custom_toast, (ViewGroup) findViewById(R.id.toast));
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(toastLayout);
                toast.show();
                Intent i=new Intent(EnterCardDetails.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}
