package com.example.root.gunaso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class Complain extends AppCompatActivity {
    EditText email,subject,body,name;
    Button send;
    String sendEmail="rumirajbhandari@gmail.com";
    //    ForumModel forumModelList=new ArrayList<ForumModel>();
    ForumModel forumModel=new ForumModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        Intent intent = getIntent();
        String value = intent.getStringExtra("rumi");

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.user_email);
        subject=(EditText)findViewById(R.id.user_subject);
        body=(EditText)findViewById(R.id.user_body);
        send=(Button)findViewById(R.id.send);

        forumModel.setName(name.toString());
        forumModel.setEmail(email.toString());
        forumModel.setBody(body.toString());
        forumModel.setSubject(subject.toString());





        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = "anjanaraut@outlook.com";
                String sub = subject.getText().toString();
                String mes = body.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, sub);
                email.putExtra(Intent.EXTRA_TEXT, mes);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));



            }
        });

    }
}



