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

public class PDFOpener extends AppCompatActivity {

    PDFView myPDFViewer;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set theme
        SharedPreferences sharedPreferences = getSharedPreferences(Themes.APP_PREFERENCES, Context.MODE_PRIVATE);
        int theme = sharedPreferences.getInt(Themes.THEME_Key, R.style.AppTheme);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);

        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer);
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PDFOpener.this, Main3Activity.class));
            }
        });
        String getItem = getIntent().getStringExtra("pdfFilesName");

        String[] pdfFiles = {"Select Surah To Read","Surah e Fatiha","Surah e Kausar","Surah e Mulk","Surah e Nisa","Surah e Rehman","Surah e Yaseen"};
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
                    myPDFViewer.fromAsset("al_fatihah.pdf").load();
                }
                if (position == 2)
                {
                    myPDFViewer.fromAsset("surah-kausar.pdf").load();
                }
                else if (position == 3)
                {
                    myPDFViewer.fromAsset("surah_mulk.PDF").load();
                }
                else if (position == 4)
                {
                    myPDFViewer.fromAsset("surah_nisa.pdf").load();
                }
                else if (position == 5)
                {
                    myPDFViewer.fromAsset("surah_rehman.PDF").load();
                }
                else if (position == 6)
                {
                    myPDFViewer.fromAsset("surah_yaseen.PDF").load();
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

        if (getItem.equals("Surah e Fatiha"))
        {
            myPDFViewer.fromAsset("al_fatihah.pdf").load();
        }
        else if (getItem.equals("Surah e Kausar"))
        {
            myPDFViewer.fromAsset("surah-kausar.pdf").load();
        }
        else if (getItem.equals("Surah e Mulk"))
        {
            myPDFViewer.fromAsset("surah_mulk.PDF").load();
        }
        else if (getItem.equals("Surah e Nisa"))
        {
            myPDFViewer.fromAsset("surah_nisa.pdf").load();
        }
        else if (getItem.equals("Surah e Rehman"))
        {
            myPDFViewer.fromAsset("surah_rehman.PDF").load();
        }
        else if (getItem.equals("Surah e Yaseen"))
        {
            myPDFViewer.fromAsset("surah_yaseen.PDF").load();
        }
        else
        {
            Toast.makeText(this, "No Matching PDF Found", Toast.LENGTH_SHORT).show();
        }

    }
}
