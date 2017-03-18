package com.example.root.gunaso;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

import static java.security.AccessController.getContext;

public class Complain extends AppCompatActivity {
    EditText email,subject,body,name;
    Button send,location;
    String to;
    String sendEmail="rumirajbhandari@gmail.com";
    //    ForumModel forumModelList=new ArrayList<ForumModel>();
    ForumModel forumModel=new ForumModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        Intent intent = getIntent();
        String value = intent.getStringExtra("rumi");

        AlertDialog.Builder builder = new AlertDialog.Builder(Complain.this);
        builder.setTitle("Please chose an action")
                .setItems(R.array.msg_to, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which){
                            case 0:
                                to="secretary@nvc.gov.np";
                                Log.e("TAG", "onClick: "+to );


                            case 1:
                                to="http://ciaa.gov.np";
                                Log.e("TAG", "onClick: "+to );
                            case 2:
                                to="1111@nepal.gov.np";
                                Log.e("TAG", "onClick: "+to );
                        }
                    }
                });;
        /*builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
*/
        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.user_email);
        subject=(EditText)findViewById(R.id.user_subject);
        body=(EditText)findViewById(R.id.user_body);
        send=(Button)findViewById(R.id.send);
        location=(Button)findViewById(R.id.location);

        forumModel.setName(name.toString());
        forumModel.setEmail(email.toString());
        forumModel.setBody(body.toString());
        forumModel.setSubject(subject.toString());





        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 to = "anjanaraut@outlook.com";
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


        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Complain.this,Map.class);
                startActivity(intent);

            }
        });

    }
}



