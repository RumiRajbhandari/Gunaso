package com.example.root.gunaso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContractDetails extends AppCompatActivity {
    ContratorModel manpowerItem;


    private Context mContext;
    TextView contract_name,awarded,contract_date,completion_date,contract_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contractor_details);


        manpowerItem= (ContratorModel) getIntent().getSerializableExtra("hello");
        contract_name=(TextView)findViewById(R.id.contract_name);
        awarded=(TextView)findViewById(R.id.awarded_to);
        contract_date=(TextView)findViewById(R.id.contract_date);
        completion_date=(TextView)findViewById(R.id.completion_date);
        contract_amount=(TextView)findViewById(R.id.contract_amount);
        contract_name.setText("Contract_name: "+manpowerItem.getTitle());
        awarded.setText("Awarded To: "+manpowerItem.getAwarded());
        contract_date.setText("Contract Name: "+manpowerItem.getContract_date());

        completion_date.setText("Completion Date: "+manpowerItem.getCompletion_date());
        contract_amount.setText("Contract_amount: "+manpowerItem.getContract_amount());

    }
}
