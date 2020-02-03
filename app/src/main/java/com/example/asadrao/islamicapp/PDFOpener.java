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
    private long backPressedTime;
    private Toast backToast;
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
                finish();
            }
        });
        String getItem = getIntent().getStringExtra("pdfFilesName");

        String[] pdfFiles = {"Select Surah to Read","Surah e Fatiha","Surah e Kausar","Surah e Mulk","Surah e Nisa","Surah e Rehman","Surah e Yaseen",
                "Surah Aadiyat","Surah Qariah","Surah Alaq","Surah Asar","Surah Falak","Surah feel","Surah Hamza",
                "Surah Ikhlas","Surah Kafirun","Surah Lahab","Surah Maoon","Surah Misid","Surah Naas","Surah Nasar",
                "Surah Qadar","Surah Quraish","Surah Takasur","Surah Teen","Surah Zilzalaha"};
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
                else if (position == 7)
                {
                    myPDFViewer.fromAsset("aadiat.pdf").load();
                }
                else if (position == 8)
                {
                    myPDFViewer.fromAsset("al_qariah.pdf").load();
                }
                else if (position == 9)
                {
                    myPDFViewer.fromAsset("alaq.pdf").load();
                }
                else if (position == 10)
                {
                    myPDFViewer.fromAsset("asr.pdf").load();
                }
                else if (position == 11)
                {
                    myPDFViewer.fromAsset("falak.pdf").load();
                }
                else if (position == 12)
                {
                    myPDFViewer.fromAsset("feel.pdf").load();
                }
                else if (position == 13)
                {
                    myPDFViewer.fromAsset("hamza.pdf").load();
                }
                else if (position == 14)
                {
                    myPDFViewer.fromAsset("ikhlas.pdf").load();
                }
                else if (position == 15)
                {
                    myPDFViewer.fromAsset("kafirun.pdf").load();
                }
                else if (position == 16)
                {
                    myPDFViewer.fromAsset("lahab.pdf").load();
                }
                else if (position == 17)
                {
                    myPDFViewer.fromAsset("maoon.pdf").load();
                }
                else if (position == 18)
                {
                    myPDFViewer.fromAsset("misd.pdf").load();
                }
                else if (position == 19)
                {
                    myPDFViewer.fromAsset("naas.pdf").load();
                }
                else if (position == 20)
                {
                    myPDFViewer.fromAsset("nasar2.pdf").load();
                }
                else if (position == 21)
                {
                    myPDFViewer.fromAsset("qadar.pdf").load();
                }
                else if (position == 22)
                {
                    myPDFViewer.fromAsset("quraish.pdf").load();
                }
                else if (position == 23)
                {
                    myPDFViewer.fromAsset("takasur.pdf").load();
                }
                else if (position == 24)
                {
                    myPDFViewer.fromAsset("teen.pdf").load();
                }
                else if (position == 25)
                {
                    myPDFViewer.fromAsset("zilzalaha.pdf").load();
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
        else if (getItem.equals("Surah Aadiyat"))
        {
            myPDFViewer.fromAsset("aadiat.pdf").load();
        }
        else if (getItem.equals("Surah Qariah"))
        {
            myPDFViewer.fromAsset("al_qariah.PDF").load();
        }
        else if (getItem.equals("Surah Alaq"))
        {
            myPDFViewer.fromAsset("alaq.pdf").load();
        }
        else if (getItem.equals("Surah Asar"))
        {
            myPDFViewer.fromAsset("asr.pdf").load();
        }
        else if (getItem.equals("Surah Falak"))
        {
            myPDFViewer.fromAsset("falak.pdf").load();
        }
        else if (getItem.equals("Surah feel"))
        {
            myPDFViewer.fromAsset("feel.pdf").load();
        }
        else if (getItem.equals("Surah Ikhlas"))
        {
            myPDFViewer.fromAsset("ikhlas.pdf").load();
        }
        else if (getItem.equals("Surah Kafirun"))
        {
            myPDFViewer.fromAsset("kafirun.pdf").load();
        }
        else if (getItem.equals("Surah Lahab"))
        {
            myPDFViewer.fromAsset("lahab.pdf").load();
        }
        else if (getItem.equals("Surah Maoon"))
        {
            myPDFViewer.fromAsset("maoon.pdf").load();
        }
        else if (getItem.equals("Surah Misid"))
        {
            myPDFViewer.fromAsset("misd.pdf").load();
        }
        else if (getItem.equals("Surah Naas"))
        {
            myPDFViewer.fromAsset("naas.pdf").load();
        }
        else if (getItem.equals("Surah Nasar"))
        {
            myPDFViewer.fromAsset("nasar2.pdf").load();
        }
        else if (getItem.equals("Surah Qadar"))
        {
            myPDFViewer.fromAsset("qadar.pdf").load();
        }
        else if (getItem.equals("Surah Quraish"))
        {
            myPDFViewer.fromAsset("quraish.pdf").load();
        }
        else if (getItem.equals("Surah Takasur"))
        {
            myPDFViewer.fromAsset("takasur.pdf").load();
        }
        else if (getItem.equals("Surah Teen"))
        {
            myPDFViewer.fromAsset("teen.pdf").load();
        }
        else if (getItem.equals("Surah Zilzalaha"))
        {
            myPDFViewer.fromAsset("zilzalaha.pdf").load();
        }
        else if (getItem.equals("Surah Hamza"))
        {
            myPDFViewer.fromAsset("hamza.pdf").load();
        }
    }

    @Override
    public void onBackPressed() {
       startActivity(new Intent(getApplicationContext(), Main3Activity.class));
       finish();
    }
}
