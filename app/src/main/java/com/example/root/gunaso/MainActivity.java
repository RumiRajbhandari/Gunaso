package com.example.root.gunaso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView contrator,complain,forum,aboutus;
    TextView survey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contrator=(ImageView) findViewById(R.id.contractor);
        complain=(ImageView)findViewById(R.id.complain);
        forum=(ImageView)findViewById(R.id.forum);
        aboutus=(ImageView)findViewById(R.id.aboutus);
        survey=(TextView)findViewById(R.id.survery);

        contrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListOfContrator.class);
                intent.putExtra("rumi","rumi");
                startActivity(intent);
            }
        });

        complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Complain.class);
                startActivity(intent);

            }
        });

        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,forum.class);
                startActivity(intent);


            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent);

            }
        });
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,survey.class);
                startActivity(intent);

            }
        });
    }
}
