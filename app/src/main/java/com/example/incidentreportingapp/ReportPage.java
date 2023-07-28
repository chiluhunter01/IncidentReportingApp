package com.example.incidentreportingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReportPage extends AppCompatActivity {


    EditText enterTxt, subject;
    Button send, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);

        getSupportActionBar().hide();

        subject = (EditText)findViewById(R.id.subject);
        enterTxt = (EditText)findViewById(R.id.enterTxt);
        send = (Button )findViewById(R.id.sendBtn);
        backBtn = (Button)findViewById(R.id.back);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);

                String emailSend = "avicmvu9@gmail.com";

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {emailSend});

                intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, enterTxt.getText().toString());

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Choose an email client : "));

                subject.getText().clear();
                enterTxt.getText().clear();

                Toast.makeText(ReportPage.this, "Report has been submitted successfully", Toast.LENGTH_SHORT).show();

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportPage.this, UserDashboard.class);
                startActivity(intent);
            }
        });
    }
}