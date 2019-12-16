package com.example.asadrao.islamicapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpenerPara extends AppCompatActivity {
    PDFView myPDFViewer;
    Button btnBack;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set theme
        SharedPreferences sharedPreferences = getSharedPreferences(Themes.APP_PREFERENCES, Context.MODE_PRIVATE);
        int theme = sharedPreferences.getInt(Themes.THEME_Key, R.style.AppTheme);
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener_para);

        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer);
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PDFOpenerPara.this, Main2Activity.class));
                finish();
            }
        });
        String getItem = getIntent().getStringExtra("pdfFilesName");

        String[] pdfFiles = {"Select Para To Read","Para No 1","Para No 2","Para No 3","Para No 4","Para No 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinnerlayout,R.id.textView,pdfFiles)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView mytext = (TextView) view.findViewById(R.id.text1);
                return view;
            }
        };

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1)
                {
                    myPDFViewer.fromAsset("2.pdf").load();
                }
                if (position == 2)
                {
                    myPDFViewer.fromAsset("3.pdf").load();
                }
                else if (position == 3)
                {
                    myPDFViewer.fromAsset("4.pdf").load();
                }
                else if (position == 4)
                {
                    myPDFViewer.fromAsset("5.pdf").load();
                }
                else if (position == 5)
                {
                    myPDFViewer.fromAsset("6.pdf").load();
                }
                else
                {
                    //Toast.makeText(PDFOpener.this, "No Matched Resource!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (getItem.equals("Para No 1"))
        {
            myPDFViewer.fromAsset("2.pdf").load();
        }
        else if (getItem.equals("Para No 2"))
        {
            myPDFViewer.fromAsset("3.pdf").load();
        }
        else if (getItem.equals("Para No 3"))
        {
            myPDFViewer.fromAsset("4.pdf").load();
        }
        else if (getItem.equals("Para No 4"))
        {
            myPDFViewer.fromAsset("5.pdf").load();
        }
        else if (getItem.equals("Para No 5"))
        {
            myPDFViewer.fromAsset("6.pdf").load();
        }
        else
        {
            Toast.makeText(this, "No Matching PDF Found", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
